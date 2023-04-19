import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TrainWordTranslate {

  static final String ANSI_RESET = "\u001B[0m";
  static final String ANSI_RED = "\u001B[31m";
  static final String ANSI_GREEN = "\u001B[32m";
  final static String EXIT = "0";

  public static void runnerTranslate() throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    printTopMenu();

    String exit = Stream.empty().toString();

    while (!exit.equals(EXIT)) {

      int randomWord = (int) Math.floor(Math.random() * MyDictionary.getWordList().size());
      printQuestion(randomWord);
      exit = read.readLine();

      if (exit.equals(MyDictionary.getWordList().get(randomWord).getDeutschWord())) {
        printPositiveFeedback();
        MyDictionary.getWordList().get(randomWord).setNumberOfMentions();
      } else if (!exit.equals(EXIT)) {
        printNegativeFeedback(randomWord);
      }
    }
  }

  private static void printTopMenu() {
    System.out.println("The task is to write a German translation of the following word.");
    System.out.println("If you want to FINISH exercise, please, press " + EXIT + ".");
    System.out.println("=================================================================");
  }

  private static void printQuestion(Integer randomWord) {
    System.out.print("WORD: ");
    System.out.println(MyDictionary.getWordList().get(randomWord).getEnglishWord());
    System.out.print("Enter your translation: ");
  }

  private static void printPositiveFeedback() {
    List<String> feedback = Arrays.asList("Rechts!", "Genau!", "Natürlich!",
        "das ist richtig, mein Schatz :)");
    Collections.shuffle(feedback);
    System.out.println(ANSI_GREEN + feedback.get(0) + ANSI_RESET);
  }

  private static void printNegativeFeedback(Integer randomWord) {
    System.out.print(ANSI_RED + "Incorrect" + ANSI_RESET);
    System.out.println(", right: " + MyDictionary.getWordList().get(randomWord).getDeutschWord());
  }
}
