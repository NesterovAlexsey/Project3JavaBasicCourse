import java.util.List;

public class MyDictionary {

  private static List<Word> wordList;

  public MyDictionary(List<Word> wordList){
    this.wordList = wordList;
  }

  public static List<Word> getWordList() {
    return wordList;
  }

  public static void setWordList(List<Word> wordList) {
    MyDictionary.wordList = wordList;
  }

  public static void printList(){
    List<Word> printing = MyDictionary.getWordList();
    for(Word x: printing){
      System.out.println(x);
    }
  }
}
