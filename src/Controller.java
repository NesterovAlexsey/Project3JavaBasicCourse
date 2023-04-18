public class Controller {

  public void openVocabulary(MyDictionary currentDictionary) {
    Vocabulary.runnerVocabulary(currentDictionary);
  }

  public void openTrain(MyDictionary currentDictionary) {
    System.out.println("Here will be Train");
  }

  public void getResult(MyDictionary currentDictionary) {
    System.out.println("Here will be Report");
  }
}
