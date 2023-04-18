import java.util.Comparator;
import java.util.Dictionary;
import java.util.List;

public class MyDictionary {

  private static List<Word> wordList;

  public MyDictionary(List<Word> wordList) {
    wordList.sort(Comparator.comparing(Word::getEnglishWord));
    this.wordList = wordList;
  }

  public static List<Word> getWordList() {
    return wordList;
  }

  public static void setWordList(List<Word> wordList) {
    MyDictionary.wordList = wordList;
  }

  public static void printList() {
    List<Word> printing = getWordList();
    for (Word x : printing) {
      System.out.println(x);
    }
  }
}
