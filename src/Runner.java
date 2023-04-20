import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

  enum Command {
    VOCABULARY,
    TRAINING,
    REPORT,
    EXIT,
  }

  public static void main(String[] args) throws IOException {

    Controller worker = new Controller();
    Arrays.stream(Command.values()).forEach(x -> System.out.println(x.ordinal() + 1 + ":" + x));

    MyDictionary currentWordList = new MyDictionary(readFile());

    Command command = readCommand();
    while (command != Command.EXIT) {
      switch (command) {
        case VOCABULARY -> worker.openVocabulary(currentWordList);
        case TRAINING -> worker.openTrain();
        case REPORT -> worker.getResult();
      }
      System.out.println();
      Arrays.stream(Command.values()).forEach(x -> System.out.println(x.ordinal() + 1 + ":" + x));
      command = readCommand();
    }
    writeToFile();
    System.out.println("Tschüssi!");
  }

  /**
   * the method reads the user's command entered both as a digit from the keyboard and as a word.
   *
   * @return Command
   * @throws IOException
   */
  public static Command readCommand() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("\nEnter the command: ");
    String command = br.readLine().toUpperCase();

    Command result = null;
    while (result == null) {
      try {
        Integer commandInt = Integer.parseInt(command);
        result = readIntNumber(commandInt);
      } catch (NumberFormatException e) {
        try {
          result = Command.valueOf(command);
        } catch (IllegalArgumentException c) {
          System.out.println("Incorrect: " + command);
        }
      }
      if (result == null) {
        System.out.print("Please, enter correct command: ");
        command = br.readLine().toUpperCase();
      }
    }
    System.out.println();
    return result;
  }

  private static Command readIntNumber(Integer commandInt) {
    return switch (commandInt) {
      case 1 -> Command.VOCABULARY;
      case 2 -> Command.TRAINING;
      case 3 -> Command.REPORT;
      case 4 -> Command.EXIT;
      default -> throw new NumberFormatException();
    };
  }

  private static List<Word> readFile() throws IOException {
    //todo try-catch
    BufferedReader read = new BufferedReader(new FileReader("res/Dictionary"));
    List<Word> result = new ArrayList<>();

    String line;
    while ((line = read.readLine()) != null) {
      int step = line.indexOf(";");
      String first = line.substring(0, step);

      int step2 = line.indexOf(";", step + 1);
      String second = line.substring(step + 1, step2);
      int third = Integer.parseInt(line.substring(step2 + 1));

      Word temporary = new Word(first, second, third);
      result.add(temporary);

    }
    return result;
  }

  private static void writeToFile() throws IOException {
    //todo try-catch
    List<Word> results = MyDictionary.getWordList();

    FileWriter output = new FileWriter("res/Dictionary");
    for (Word word : results) {
      output.write(
          word.getDeutschWord() + ";"
              + word.getEnglishWord() + ";"
              + word.getNumberOfMentions() + "\n");
    }
    output.close();
  }
}
