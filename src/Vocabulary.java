import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Vocabulary {

  public static void runnerVocabulary(MyDictionary currentDictionary) throws IOException {

    printVocabularyMenu();
    int command = readVocabularyCommand(currentDictionary);

//    currentDictionary.printList();
  }

  private static void printVocabularyMenu() {
    System.out.println("_______________________________________");
    System.out.println("1. View the English-German dictionary;");
    System.out.println("2. Add new word to Dictionary");
    System.out.println("3. Delete word from Dictionary");
    System.out.println("4. Translation of an English-German word");
    System.out.println("5. Translation of an German-English word");
    System.out.println("_______________________________________");
  }

  private static int readVocabularyCommand(MyDictionary currentDictionary) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int command = -1;

    try {
      command = Integer.parseInt(read.readLine());
    } catch (NumberFormatException e) {
      System.out.println("Incorrect input data: " + e);
      runnerVocabulary(currentDictionary);
    }

    return command;
  }
}
