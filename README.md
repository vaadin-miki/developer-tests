# Overview

This repository contains a few tasks to implement during a developer interview task.

This branch contains a general programming task.

# TL;DR

1. Clone this repository.
1. Run the tests (`mvn test` or run `CalculatorTest`).
1. Implement missing code so that all the tests pass.
1. ???
1. PROFIT.

# More details

You **are allowed** to search the web for any API or code examples related to your tasks. You are **not allowed** to search for solutions ;) 

Whenever you are unclear about what exactly is expected, **ask immediately**.

## Calculator

Your task here is to implement a calculator that works on a String input. Go to `CalculatorProvider.getCalculator()` and start from there. Please treat this task as a regular software development project. You are allowed to create classes, interfaces, methods, etc. according to your needs and understanding of the code.

At the beginning your calculator must support the following syntax: `(number) (operation) (number)` - two numbers and one operation. There might be white space around the `operation`, but it is not required. There is no trailing or leading white space.
* the following `operation`s must be supported at first:
  - `+` for addition,
  - `-` for subtraction,
  - `*` for multiplication,
  - `/` for integer division,
  - `%` for division remainder;
* `number` is a positive integer.

The requirements **will change** during the interview. There might be two to three additional iterations, based on your skills and time left.

You have approximately 60 minutes for all the steps, although this is not a hard limit. Once all the tests pass for the final step, congratulations!