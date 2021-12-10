package todo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndToEndTest {

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
    @Disabled
    public void echoTest() throws IOException {

        String command = "echo";
        String arg = "test";

        Process myProcess = new ProcessBuilder(command, arg).start();

        assertEquals(arg, outContent.toString());
    }

    @Test
    @Disabled
    public void todo() throws IOException {
        String command = "java"; //"java -classpath \"target\\classes\" todo.Application";
        String classpath = "-classpath";
        String arg = "java -classpath target\\classes todo.Application";

        //Process myProcess = new ProcessBuilder(command, classpath, "target\\classes todo.Application").start();

        Process process = Runtime.getRuntime().exec(arg);

        assertEquals(10, Application.count);
    }
}
