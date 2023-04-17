import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Runner {

  enum Command {
    NEW, // закрытие чека должно открыть следующий
    ADD, // добавить товар (строку) в чек
    REPORT, // вывести отчёт
    EXIT, // выход из программы
  }

  private static final Map<Command, String> commands = new HashMap<>();

  static { // так можно задать статический константный словарь (Map)
    commands.put(Command.NEW, "Начать новый чек");
    commands.put(Command.ADD, "Добавить позицию в чек");
    commands.put(Command.REPORT, "Вывести отчёт");
    commands.put(Command.EXIT, "Выход");
  }

//  public static void main(String[] args) throws IOException {
//    Register cashRegister = new Register();
//
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
//  }

  public static void printMenu() {
    System.out.println(); // пустая строка для красоты
    System.out.println("Список команд:");
    for (Command command : commands.keySet()) {
      System.out.println("- " + command + ": " + commands.get(command));
    }
  }

  public static Command readCommand() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    printMenu();
    System.out.println(); // пустая строка для красоты
    System.out.print("Введите команду: ");
    String command = br.readLine().toUpperCase();

    Command result = null;
    while (result == null) { // пока команда не установлена
      try {
        result = Command.valueOf(command); // пытаемся установить команду
      } catch (IllegalArgumentException e) {
        System.out.println("Некорректная команда: " + command);
        System.out.print("Введите корректную команду: ");
        command = br.readLine().toUpperCase();
      }
    }

    System.out.println(); // пустая строка для красоты
    return result;
  }
}
