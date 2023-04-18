public class Word {

  private String englishWord;
  private String deutschWord;

  private int numberOfMentions = 0;

  public Word(String englishWord, String deutschWord) {
    this.englishWord = englishWord;
    this.deutschWord = deutschWord;
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

  public void setNumberOfMentions(int numberOfMentions) {
    this.numberOfMentions = numberOfMentions;
  }
}
