import java.io.IOException;

public class Controller {
  final static int LEARNED = 2;

  public void openVocabulary(MyDictionary currentDictionary) throws IOException {
    Vocabulary.runnerVocabulary(currentDictionary);
  }

  public void openTrain() throws IOException {
    TrainWordTranslate.runnerTranslate(LEARNED);
  }

  public void getResult() {
    Report.runReport(LEARNED);
  }
}
