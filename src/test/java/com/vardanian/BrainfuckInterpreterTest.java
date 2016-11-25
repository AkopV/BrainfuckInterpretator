package com.vardanian;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BrainfuckInterpreterTest {

    private BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter();

    private String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++\n" +
            " .>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
            " ------.--------.>+.>.";

    @Test
    public void interpreterTest() {
        String expected = "Hello World!\n";
        String actual = brainfuckInterpreter.interpreter(code);
        assertEquals(expected, actual);
    }
}
