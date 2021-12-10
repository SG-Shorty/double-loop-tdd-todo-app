package todo;

public class Application {

    public static final String NO_TODOS_AVAILABLE = "No Todos available";
    public static final String COMMAND_SHOW_TODOS = "showTodos";
    public static final String COMMAND_ADD_TODO = "addTodo";
    public static final String TODO_GESPEICHERT_MELDUNG = "Todo -%s- wurde gespeichert";
    public static int count;

    public static void main(String[] args) {
        String command = args[0];
        if (command.equals(COMMAND_SHOW_TODOS)) {
            System.out.print(NO_TODOS_AVAILABLE);
        } else if (command.equals(COMMAND_ADD_TODO)) {
            System.out.print(getTodoGespeichertMeldung(args[1]));
        }
    }

    static String getTodoGespeichertMeldung(String arg) {
        return String.format(TODO_GESPEICHERT_MELDUNG, arg);
    }
}
