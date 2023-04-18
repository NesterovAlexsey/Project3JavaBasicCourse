import java.util.Comparator;
import java.util.Dictionary;
import java.util.List;

public class MyDictionary {

  private static List<Word> wordList;

  public MyDictionary(List<Word> wordList) {
    this.wordList = wordList;
  }

  public static List<Word> getWordList() {
    return wordList;
  }

  public static void setWordList(List<Word> wordList) {
    MyDictionary.wordList = wordList;
  }

  public static void printSortEnglishList() {
    List<Word> printing = getWordList();
    printing.sort(Comparator.comparing(Word::getEnglishWord));
    for (Word x : printing) {
      System.out.println(x);
    }
  }
}
