package todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void showEmptyTodos() {
        String[] showTodoComment = {Application.COMMAND_SHOW_TODOS};

        Application.main(showTodoComment);

        assertEquals(Application.NO_TODOS_AVAILABLE, outContent.toString());
    }

    @Test
    public void addTodo() {
        String[] addTodoArguments = {Application.COMMAND_ADD_TODO,"Einkaufen gehen"};

        Application.main(addTodoArguments);

        String result = "Todo -Einkaufen gehen- wurde gespeichert";
        assertEquals(result, outContent.toString());
    }
}
