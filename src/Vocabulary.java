import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Vocabulary {

  final static int VIEW = 1;
  final static int ADD = 2;
  final static int DELETE = 3;
  final static int TRANSLATE = 4;
  final static int MENU = 5;

  public static void runnerVocabulary(MyDictionary currentDictionary) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

//todo избавиться от передачи словаря
    printVocabularyMenu();
    int command = readVocabularyCommand(currentDictionary, read);
    while (command != MENU) {
      switch (command) {
        case VIEW -> MyDictionary.printList();
        case ADD -> addWord(read);
        case DELETE -> deleteWord(read);
        case TRANSLATE -> translateEGWord(read);
        default -> System.out.println("Incorrect input data");
      }
      printVocabularyMenu();
      command = readVocabularyCommand(currentDictionary, read);
    }
  }

  private static void printVocabularyMenu() {
    System.out.println("_______________________________________");
    System.out.println(VIEW + ". View the English-German dictionary;");
    System.out.println(ADD + ". Add new word to Dictionary");
    System.out.println(DELETE + ". Delete word from Dictionary");
    System.out.println(TRANSLATE + ". Translation of an English-German word");
    System.out.println(MENU + ". Back to Menu");
    System.out.println("_______________________________________");
  }

  private static int readVocabularyCommand(MyDictionary currentDictionary, BufferedReader read)
      throws IOException {

    int command = -1;

    try {
      command = Integer.parseInt(read.readLine());
    } catch (NumberFormatException e) {
      System.out.println("Incorrect input data: " + e);
      runnerVocabulary(currentDictionary);
    }

    return command;
  }

  private static void addWord(BufferedReader read) throws IOException {
    //todo код рефактор
    System.out.print("Please, enter English word: ");
    String englishWord = read.readLine();
    System.out.print("Please, enter Deutsch word: ");
    String deutschWord = read.readLine();
    Word userWord = new Word(deutschWord, englishWord);
    List<Word> checkList = MyDictionary.getWordList();

    int position = Collections.binarySearch(checkList, userWord, Word::compareTo);
    if (position < 0) {
      checkList.add((-position - 1), userWord);
      MyDictionary.setWordList(checkList);
      System.out.println("Word '" + userWord + "' have been successfully added");
    } else {
      System.out.println("Word '" + checkList.get(position) + "' have been already in the list");
    }
  }

  private static void deleteWord(BufferedReader read) throws IOException {
    System.out.print("Please, enter English word for delete: ");
    String targetWord = read.readLine();
    Word userWord = new Word(targetWord, targetWord);
    List<Word> checkList = MyDictionary.getWordList();

    int position = Collections.binarySearch(checkList, userWord, Word::compareTo);
    if (position < 0) {
      System.out.println("Word '" + targetWord + "' do not exist in the list");
    } else {
      checkList.remove(position);
      MyDictionary.setWordList(checkList);
      System.out.println("Word '" + userWord.getEnglishWord() + "' have been successfully delete");
    }
  }

  private static void translateEGWord(BufferedReader read) throws IOException{
    System.out.print("Enter word for translation: ");
    String targetW = read.readLine();
    Word target = new Word(targetW, targetW);
    int position = Collections.binarySearch(MyDictionary.getWordList(), target, Word::compareTo);
    if (position < 0) {
      System.out.println("There is NO word " + targetW + "in dictionary");
    } else {
      String result = MyDictionary.getWordList().get(position).getDeutschWord();
      System.out.println("Translation " + targetW + " : " + result);
    }
  }
}
