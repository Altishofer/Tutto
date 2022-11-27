package Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class InputOutputUtilsTest {

    @Test
    void doSleep() {
    }

    @Test
    void getIntegerInputValid() {
        String input = "12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int out = InputOutputUtils.getIntegerInput("consoleText");
        String expected = "consoleText";
        assertEquals(expected, outContent.toString());
        assertEquals(12, out);
    }

    @Test
    void getIntegerInputNegative() {
        String input = "-45" + "\n12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int out = InputOutputUtils.getIntegerInput("consoleText");
        String expected = "consoleTextconsoleText";
        assertEquals(expected, outContent.toString());
        assertEquals(12, out);
    }

    @Test
    void getIntegerInputZero() {
        String input = "0" + "\n0" + "\n12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int out = InputOutputUtils.getIntegerInput("consoleText");
        String expected = "consoleTextconsoleTextconsoleText";
        assertEquals(expected, outContent.toString());
        assertEquals(12, out);
    }

    @Test
    void getIntegerInputNotInt() {
        String input = "abc" + "\n12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        int out = InputOutputUtils.getIntegerInput("consoleText");
        String expected = "consoleTextconsoleText";
        assertEquals(expected, outContent.toString());
        assertEquals(12, out);
    }
}