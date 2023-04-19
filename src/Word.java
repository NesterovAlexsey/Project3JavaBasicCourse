public class Word implements Comparable<Word> {
  //todo обновить Word, чтобы сохранять количество упоминаний
  private String deutschWord;

  private String englishWord;

  private int numberOfMentions = 0;

  public Word(String deutschWord, String englishWord) {
    this.deutschWord = deutschWord;
    this.englishWord = englishWord;
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

  public void setDeutschWord(String deutschWord) {
    this.deutschWord = deutschWord;
  }

  public void setEnglishWord(String englishWord) {
    this.englishWord = englishWord;
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
