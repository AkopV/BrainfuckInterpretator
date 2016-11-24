package com.vardanian;

public class BrainfuckInterpreter {

    private final int CAPACITY = 30000;

    private char[] memory = new char[CAPACITY];

    public void interpreterSymbols(char[] arraySymbols) {

        int point = 0;

        StringBuilder output;

        for (int i = 0; i < arraySymbols.length; i++) {
            int start = 0;

            if (arraySymbols[i] == '>') {
                if (point != CAPACITY-1) {
                    point++;
                }
            } else if (arraySymbols[i] == '<') {
                if (point != CAPACITY-1) {
                    point--;
                }
            } else if (arraySymbols[i] == '+') {
                memory[point]++;
            } else if (arraySymbols[i] == '-') {
                memory[point]--;
            } else if (arraySymbols[i] == '.') {
                System.out.print(memory[point]);
            }
            else if (arraySymbols[i] == '[') {
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
            } else if (arraySymbols[i] == ']') {
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
            }
        }
    }

    public static void main(String[] args) {

        BrainfuckInterpreter brainfuckInterpreter = new BrainfuckInterpreter();

        String code = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++\n" +
                " .>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.\n" +
                " ------.--------.>+.>.";

        char[] symbols = code.toCharArray();

        brainfuckInterpreter.interpreterSymbols(symbols);
    }
}
