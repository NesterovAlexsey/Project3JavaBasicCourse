public class Word implements Comparable<Word> {
  private final String deutschWord;

  private final String englishWord;

  private int numberOfMentions = 0;

  public Word(String deutschWord, String englishWord) {
    this.deutschWord = deutschWord;
    this.englishWord = englishWord;
  }

  public Word(String deutschWord, String englishWord, int numberOfMentions){
    this.deutschWord = deutschWord;
    this.englishWord = englishWord;
    this.numberOfMentions = numberOfMentions;
  }

  public String getDeutschWord() {
    return deutschWord;
  }

  public String getEnglishWord() {
    return englishWord;
  }

  public int getNumberOfMentions() {
    return numberOfMentions;
  }

  public void setNumberOfMentions() {
    numberOfMentions++;
  }

  @Override
  public String toString() {
    return getEnglishWord() + " : " + getDeutschWord();
  }

  @Override
  public int compareTo(Word other) {
    return englishWord.compareTo(other.englishWord);
  }
}
