import java.util.List;

public class Report {
  final static int LEARNED = 2;
  final static int FRAME = 20;
  static final String ANSI_RESET = "\u001B[0m";
  static final String ANSI_GREEN = "\u001B[32m";
  static final String ANSI_YELLOW = "\u001B[33m";
  public static void runReport(){
    List<Word> report = MyDictionary.getWordList();
    int doneWord = (int) report.stream()
        .filter(Word -> Word.getNumberOfMentions() > LEARNED)
        .count();

    int processWord = (int) report.stream()
        .filter(Word -> (Word.getNumberOfMentions() < LEARNED) && Word.getNumberOfMentions() > 0)
        .count();

    System.out.printf("Number of learned word: %d / %d%n", doneWord, report.size());
    System.out.printf("Number of word in progress: %d / %d%n", processWord, report.size());
    System.out.printf("TOTAL LEARNED: %d%n", doneWord/ report.size() * 100);

    printBeauty(doneWord, processWord, report.size());

  }

  private static void printBeauty(Integer doneWord, Integer processWord, Integer total){
    for (int i = 0; i < FRAME-1; i++){
      System.out.print("-");
    }
    System.out.println();
    System.out.print("|");
    int done = doneWord / total * FRAME;
    for (int i = 0; i < done; i++){
      System.out.print(ANSI_GREEN + "0" + ANSI_RESET);
    }
    int progress = processWord / total * FRAME;
    for (int i = 0; i < progress; i++){
      System.out.print(ANSI_YELLOW + "0" + ANSI_RESET);
    }
    System.out.print("|");
    System.out.println();
    for (int i = 0; i < FRAME-1; i++){
      System.out.print("-");
    }
    System.out.println();
  }
}
