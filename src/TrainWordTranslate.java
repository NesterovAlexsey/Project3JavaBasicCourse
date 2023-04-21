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

  public static void runnerTranslate(Integer LEARNED) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    printTopMenu();

    String exit = Stream.empty().toString();
    while (!exit.equals(EXIT)) {

      List<Word> train = MyDictionary.getWordList()
          .stream()
          .filter(Word -> Word.getNumberOfMentions() < LEARNED)
          .toList();

      if (train.isEmpty()) {
        System.out.println("GREAT! all Vocabulary have been learned! GOOD JOB!");
        exit = EXIT;
        continue;
      }

      int randomWord = (int) Math.floor(Math.random() * train.size());
      printQuestion(randomWord, train);
      exit = read.readLine();

      if (exit.equals(train.get(randomWord).getDeutschWord())) {
        printPositiveFeedback();
        changeNumberOfMention(train, randomWord);
      } else if (!exit.equals(EXIT)) {
        printNegativeFeedback(randomWord, train);
      }
    }
  }

  private static void printTopMenu() {
    System.out.println("The task is to write a German translation of the following word.");
    System.out.println("If you want to FINISH exercise, please, press " + EXIT + ".");
    System.out.println("=================================================================");
  }

  private static void printQuestion(Integer randomWord, List<Word> train) {
    System.out.print("WORD: ");
    System.out.println(train.get(randomWord).getEnglishWord());
    System.out.print("Enter your translation: ");
  }

  private static void printPositiveFeedback() {
    List<String> feedback = Arrays.asList("Rechts!", "Genau!", "Natürlich!",
        "das ist richtig, mein Schatz :)");
    Collections.shuffle(feedback);
    System.out.println(ANSI_GREEN + feedback.get(0) + ANSI_RESET);
  }

  private static void printNegativeFeedback(Integer randomWord, List<Word> train) {
    System.out.print(ANSI_RED + "Incorrect" + ANSI_RESET);
    System.out.println(", right: " + train.get(randomWord).getDeutschWord());
  }

  private static void changeNumberOfMention(List<Word> train, Integer randomWord){
    int position = Collections.binarySearch(MyDictionary.getWordList(), train.get(randomWord),
        Word::compareTo);
    MyDictionary.getWordList().get(position).setNumberOfMentions();
  }
}
