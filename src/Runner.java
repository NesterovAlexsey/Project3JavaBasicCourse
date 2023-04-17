import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

  enum Command {
    VOCABULARY,
    TRAINING,
    REPORT,
    EXIT,
  }


  private static List<Command> listOfCommand() {
    List<Command> menu = new ArrayList<>();

    menu.add(Command.VOCABULARY);
    menu.add(Command.TRAINING);
    menu.add(Command.REPORT);
    menu.add(Command.EXIT);

    return menu;
  }

  public static void main(String[] args) throws IOException {
    Distributor worker = new Distributor();

    Command command = readCommand();
    while (command != Command.EXIT) {
      switch (command) {
        case VOCABULARY -> worker.openVocabular();
        case TRAINING -> worker.openTrain();
        case REPORT -> worker.getResult();
      }
      command = readCommand();
    }
    System.out.println("Tschüss!");
  }

  public static void printMenu() {
    System.out.println();
    System.out.println("List of command:");
    List<Command> forPrint = listOfCommand();
    for (Command command : forPrint) {
      System.out.println(command);
    }
  }

  public static Command readCommand() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    printMenu();
    System.out.println();
    System.out.print("Enter the command: ");
    String command = br.readLine().toUpperCase();

    Command result = null;
    while (result == null) {
      try {
        result = Command.valueOf(command);
      } catch (IllegalArgumentException e) {
        System.out.println("Incorrect: " + command);
        System.out.print("Please, enter correct command: ");
        command = br.readLine().toUpperCase();
      }
    }

    System.out.println();
    return result;
  }
}
