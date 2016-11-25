package com.vardanian;

public class BrainfuckInterpreter {

    private final int CAPACITY = 30000;

    private char[] memory = new char[CAPACITY];

    private int point = 0;

    // increment the pointer (to point to the next cell to the right).
    public void next() {
        if (point != CAPACITY - 1) {
            point++;
        }
    }

    //decrement the pointer (to point to the next cell to the left).
    public void prev() {
        if (point != CAPACITY - 1) {
            point--;
        }
    }

    //increment (increase by one) the array at the pointer.
    public void add() {
        memory[point]++;
    }

    //decrement (decrease by one) the array at the data pointer.
    public void substract() {
        memory[point]--;
    }

    // output the value.
    public char print() {
        return memory[point];
    }

    /**
     * if the array at the memory pointer is zero,
     * then instead of moving the instruction pointer forward to the next command,
     * jump it forward to the command after the matching ']' command
     *
     * @param arraySymbols
     */
    public void brOpen(char[] arraySymbols) {
        for (int i = 0; i < arraySymbols.length; i++) {
            int start = 0;
            if (memory[point] == 0) {
                i++;
                while (start > 0 || arraySymbols[i] != ']') {
                    if (arraySymbols[i] == '[') {
                        start++;
                    }
                    if (arraySymbols[i] == ']') {
                        start--;
                    }
                    i++;
                }
            }
        }
    }

    public String interpreter(String text) {
        char[] arraySymbols = text.toCharArray();
        String output = "";
        for (int i = 0; i < arraySymbols.length; i++) {
            int start = 0;
            char currentCommand = arraySymbols[i];
            switch (currentCommand) {
                case '>':
                    next();
                    break;
                case '<':
                    prev();
                    break;
                case '+':
                    add();
                    break;
                case '-':
                    substract();
                    break;
                case '.':
                    output += (print());
                    break;
                case '[':
                    brOpen(arraySymbols);
                    break;
                /**if the array at the memory pointer is nonzero,
                 * then instead of moving the instruction pointer forward to the next command,
                 * jump it back to the command after the matching '[' command.*/
                case ']':
                    if (memory[point] != 0) {
                        i--;
                        while (start > 0 || arraySymbols[i] != '[') {
                            if (arraySymbols[i] == ']') {
                                start++;
                            }
                            if (arraySymbols[i] == '[') {
                                start--;
                            }
                            i--;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return output;
    }

    public static void main(String[] args) {

        BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter();

        String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++\n" +
                " .>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
                " ------.--------.>+.>.";

        String res = brainfuckInterpreter.interpreter(code);

        System.out.println(res);
    }
}
