import java.util.List;

public class Report {
  final static int FRAME = 20;
  static final String RESET = "\u001B[0m";
  static final String GREEN = "\u001B[32m";
  static final String YELLOW = "\u001B[33m";
  static final String GREY = "\u001B[37m";

  public static void runReport(Integer LEARNED) {
    List<Word> report = MyDictionary.getWordList();

    int doneWord = getDoneWord(LEARNED, report);
    int processWord = getProgressWord(LEARNED, report);

    System.out.printf("Number of learned word: %d / %d%n", doneWord, report.size());
    System.out.printf("Number of word in progress: %d / %d%n", processWord, report.size());

    printBeauty(doneWord, processWord, report.size());
  }

  public static int getDoneWord(Integer LEARNED, List<Word> report){
    return (int) report.stream()
        .filter(Word -> Word.getNumberOfMentions() >= LEARNED)
        .count();
  }

  private static int getProgressWord(Integer LEARNED, List<Word> report){
    return (int) report.stream()
        .filter(Word -> (Word.getNumberOfMentions() < LEARNED) && (Word.getNumberOfMentions() > 0))
        .count();
  }

  private static void printBeauty(Integer doneWord, Integer processWord, Integer total) {

    int done = ((doneWord * 100) / total * FRAME) / 100;
    int progress = ((processWord * 100) / total * FRAME) / 100;

    for (int i = 1; i <= FRAME; i++) {
      if (i <= done) {
        System.out.print(GREEN + "\u25AE" + RESET);
      } else if (i <= done + progress) {
        System.out.print(YELLOW + "\u25AE" + RESET);
      } else {
        System.out.print(GREY + "\u25AE" + RESET);
      }
    }
    System.out.println();
  }
}
