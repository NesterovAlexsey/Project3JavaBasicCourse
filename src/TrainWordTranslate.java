import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TrainWordTranslate {

  final static String EXIT = "0";

  public static void runnerTranslate() throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("The task is to write a German translation of the following word.");
    System.out.println("If you want to FINISH exercise, please, press " + EXIT + ".");

    String exit = null;

    while (exit != EXIT) {

      int randomWord = (int) Math.floor(Math.random() * MyDictionary.getWordList().size());
      System.out.println(MyDictionary.getWordList().get(randomWord).getEnglishWord());
      System.out.print("Enter your translation: ");

      exit = read.readLine();

      if (exit.equals(MyDictionary.getWordList().get(randomWord).getDeutschWord())) {
        List<String> feedback = Arrays.asList("Rechts!", "Genau", "Natürlich",
            "das ist richtig, mein Schatz :)");
        Collections.shuffle(feedback);
        System.out.println(feedback.get(0));
        MyDictionary.getWordList().get(randomWord).setNumberOfMentions();
        continue;
      }
      if (exit.equals(EXIT)) {
        break;
      }

      System.out.println(
          "Incorrect, should be: " + MyDictionary.getWordList().get(randomWord).getDeutschWord());

    }
  }

}
