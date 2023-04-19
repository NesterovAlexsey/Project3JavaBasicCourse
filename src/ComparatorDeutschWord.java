import java.util.Comparator;

public class ComparatorDeutschWord implements Comparator<Word> {

  @Override
  public int compare(Word o1, Word o2) {
    return o1.getDeutschWord().compareTo(o2.getDeutschWord());
  }
}

