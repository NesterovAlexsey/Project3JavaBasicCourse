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

  private static List<Map<Integer, Command>> listOfCommand(){
    List<Map<Integer, Command>> menu = new ArrayList<>();

    Map<Integer, Command> firstCommand = new HashMap<>();
    firstCommand.put(1,Command.VOCABULARY);

    Map<Integer, Command> secondCommand = new HashMap<>();
    secondCommand.put(2,Command.TRAINING);

    Map<Integer, Command> thirdCommand = new HashMap<>();
    thirdCommand.put(3,Command.REPORT);

    Map<Integer, Command> exitCommand = new HashMap<>();
    exitCommand.put(0,Command.EXIT);

    menu.add(firstCommand);
    menu.add(secondCommand);
    menu.add(thirdCommand);
    menu.add(exitCommand);

    return menu;
  }

  public static void main(String[] args) throws IOException {
    Distributor worker = new Distributor();
    printMenu();

//    Command command = readCommand();
//    while (command != Command.EXIT) { // основной рабочий цикл программы, обрабатывающий команды
//      switch (command) {
//        case ADD -> {
//          ReceiptLine line = ReceiptLine.readReceiptLine();
//          cashRegister.addLine(line);
//        }
//        case NEW -> cashRegister.newReceipt();
//        case REPORT -> cashRegister.printReport();
//      }
//      command = readCommand(); // команда EXIT просто завершит цикл
//    }
//    System.out.println("До свидания!");
  }

  public static void printMenu() {
    System.out.println();
    System.out.println("List of command:");
    List<Map<Integer, Command>> forPrint = listOfCommand();
    for (Map<Integer, Command> command : forPrint) {
      System.out.println(command);
    }
  }

//  public static Command readCommand() throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    printMenu();
//    System.out.println(); // пустая строка для красоты
//    System.out.print("Введите команду: ");
//    String command = br.readLine().toUpperCase();
//
//    Command result = null;
//    while (result == null) { // пока команда не установлена
//      try {
//        result = Command.valueOf(command); // пытаемся установить команду
//      } catch (IllegalArgumentException e) {
//        System.out.println("Некорректная команда: " + command);
//        System.out.print("Введите корректную команду: ");
//        command = br.readLine().toUpperCase();
//      }
//    }
//
//    System.out.println(); // пустая строка для красоты
//    return result;
//  }
}
