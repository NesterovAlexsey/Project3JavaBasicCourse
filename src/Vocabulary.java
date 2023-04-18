import java.util.List;

public class Vocabulary {

  public static void runnerVocabulary(MyDictionary currentDictionary) {

    printVocabularyMenu();

//    currentDictionary.printList();
  }

  private static void printVocabularyMenu(){
    System.out.println("_______________________________________");
    System.out.println("1. View the English-German dictionary;");
    System.out.println("2. Add new word to Dictionary");
    System.out.println("3. Delete word from Dictionary");
    System.out.println("4. Translation of an English-German word");
    System.out.println("5. Translation of an German-English word");
    System.out.println("_______________________________________");
  }
}
