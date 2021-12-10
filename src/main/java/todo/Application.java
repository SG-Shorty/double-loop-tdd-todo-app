package todo;

public class Application {

    public static final String NO_TODOS_AVAILABLE = "No Todos available";
    public static final String COMMAND_SHOW_TODOS = "showTodos";
    public static final String COMMAND_ADD_TODO = "addTodo";
    public static int count;

    public static void main(String[] args) {
        String command = args[0];
        if (command.equals(COMMAND_SHOW_TODOS)) {
            System.out.print(NO_TODOS_AVAILABLE);
        } else if (command.equals(COMMAND_ADD_TODO)) {
            System.out.print("Todo -" + args[1] + "- wurde gespeichert");
        }
    }
}
