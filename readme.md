BrainfuckInterpretator [![Build Status](https://travis-ci.org/AkopV/BrainfuckInterpretator.svg?branch=master)](https://travis-ci.org/AkopV/BrainfuckInterpretator)

Brainfuck it was designed by Urban Müller in 1993 with the aim to be a programming language suitable for a Turing Machine using the smallest possible compiler.

This language comprehend of only eight elementary instruction, two of them are user for basic I/O.

'>' increment the pointer (to point to the next cell to the right).

'<' decrement the pointer (to point to the next cell to the left).

'+' increment (increase by one) the array at the pointer.

'—' decrement (decrease by one) the array at thepointer.

'.' output the value. 

'[' if the byte at the pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching ']' command.

']' if the byte at the pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching '[' command.
