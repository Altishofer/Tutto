package Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InputOutputUtilsTest {

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
        String expected = "consoleTextPlease enter an integer number greater than 0.consoleText";
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
        String expected = "consoleTextPlease enter an integer number greater than 0.consoleTextPlease enter an integer number greater than 0.consoleText";
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
        String expected = "consoleTextPlease enter an integer number greater than 0.consoleText";
        assertEquals(expected, outContent.toString());
        assertEquals(12, out);
    }

    @Test
    void cleanUpUserInputNull() {
        int[] expected = new int[6];
        int[] actual = InputOutputUtils.cleanUpUserInput(null);

        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    void cleanUpUserInputNotInt() {
        int[] expected = new int[6];
        int[] actual = InputOutputUtils.cleanUpUserInput("a,b,c,d");

        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    void cleanUpUserInputInvalidInt() {
        int[] expected = new int[6];
        int[] actual = InputOutputUtils.cleanUpUserInput("1,2,3,7");

        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    void cleanUpUserInputInvalidSplit() {
        int[] expected = new int[6];
        int[] actual = InputOutputUtils.cleanUpUserInput("12,3,4");

        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    void cleanUpUserInputInvalidMixed() {
        int[] expected = new int[6];
        int[] actual = InputOutputUtils.cleanUpUserInput("1,2,b,4");

        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    void cleanUpUserInputValid() {
        int[] expected = new int[6];
        expected[0] = 3;
        expected[3] = 1;
        int[] actual = InputOutputUtils.cleanUpUserInput("1,1,1,4");

        assertEquals(true, Arrays.equals(expected, actual));
    }
}