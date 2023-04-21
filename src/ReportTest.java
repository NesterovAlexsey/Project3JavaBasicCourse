import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {

  @Test
  public void getDoneWordCheck() {
    List<Word> test = new ArrayList<>();
    Word first = new Word("AAA", "aaa", 0);
    Word second = new Word("BBB", "b", 3);
    Word third = new Word("CCC", "c", 1);
    Word fore = new Word("D", "d", 3);
    Word next = new Word("K", "k", 1);
    Word last = new Word("L", "l", 3);

    test.add(first);
    test.add(second);
    test.add(third);
    test.add(fore);
    test.add(next);
    test.add(last);

    int result = Report.getDoneWord(2, test);

    assertEquals(3, result);
  }
}
