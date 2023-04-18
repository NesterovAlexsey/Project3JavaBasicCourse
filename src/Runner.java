import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

public class Runner {

  enum Command {
    VOCABULARY,
    TRAINING,
    REPORT,
    EXIT,
  }

  public static void main(String[] args) throws IOException {
    //ToDO обновить вывод и поиск по ключу, теория по енам
    Controller worker = new Controller();
    Arrays.stream(Command.values()).forEach(x -> System.out.println(x.ordinal() + 1 + ":" + x));

    MyDictionary currentWordList = new MyDictionary(readFile());

    Command command = readCommand();
    while (command != Command.EXIT) {
      switch (command) {
        case VOCABULARY -> worker.openVocabulary(currentWordList);
        case TRAINING -> worker.openTrain(currentWordList);
        case REPORT -> worker.getResult(currentWordList);
      }
      command = readCommand();
    }
    writeToFile(currentWordList);
    System.out.println("Tschüss!");
  }

  public static Command readCommand() throws IOException {
    //Todo обновить, чтобы работал по нажатию на цифру также
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println();
    System.out.print("Enter the command: ");
    String command = br.readLine().toUpperCase();

    Command result = null;
    while (result == null) {
      try {
        result = Command.valueOf(command);
      } catch (IllegalArgumentException e) {
        System.out.println("Incorrect: " + command);
        System.out.print("Please, enter correct command: ");
        command = br.readLine().toUpperCase();
      }
    }
    System.out.println();
    return result;
  }

  private static List<Word> readFile() throws IOException{
    //todo try-catch
    BufferedReader read = new BufferedReader(new FileReader("res/Dictionary"));
    List<Word> result = new ArrayList<>();
    String first = "";
    String second = "";
    Word temporary = new Word(first, second);


    String line;
    while ((line = read.readLine()) != null) {
      //first =
      temporary = new Word(first, second);
      String[] dataArray = line.split(";");
      for (String data : dataArray) {
        result.add(temporary);
      }
    }

    return result;
  }

  private static void writeToFile(MyDictionary temporary){
    //todo запись в файл сделать
  }
}
