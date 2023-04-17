import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Controller {

  public void openVocabulary(MyDictionary currentDictionary) {
    Vocabulary.runnerVocabulary(currentDictionary);
    System.out.println("Here will be Vocabulary");
  }

  public void openTrain(MyDictionary currentDictionary) {
    System.out.println("Here will be Train");
  }

  public void getResult(MyDictionary currentDictionary) {
    System.out.println("Here will be Report");
  }
}
