import java.io.IOException;

public class Controller {

  public void openVocabulary(MyDictionary currentDictionary) throws IOException {
    Vocabulary.runnerVocabulary(currentDictionary);
  }

  public void openTrain() {
    System.out.println("Here will be Train");
  }

  public void getResult(MyDictionary currentDictionary) {
    System.out.println("Here will be Report");
  }
}
