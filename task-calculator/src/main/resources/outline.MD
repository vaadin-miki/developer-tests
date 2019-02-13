# Instructions for the interviewer

The following changes in requirements are introduced in each step.

## Step 1 (starting point)

Calculator supports syntax of `number operation number`, where:
* `number` is a positive decimal integer,
* `operation` is one of `+ - * / %` (addition, subtraction, multiplication, integer division and integer division remainer).

## Step 2

One new operation is added, `**` or `^`, for exponentiation.
 
In addition, `:` should be supported as an alias for `/`.

## Step 3

Numbers can come in different bases from 2 to 16, when suffixed with `#base` (e.g. `101#2`). When there is no base given, 10 is the default.

Additional digits are `abcdef` for 10 to 15. The input should be case-insensitive, so `AF#16 af#16 Af#16` and `aF#16` represent the same number.

## Step 4 (ending point)

The calculator should support entering only one number, without the `operation` and the other `number`. If such input is encountered, it should just return the number.

## Step 5 (discussion)

What needs to be done to support expressions such as `2 + 3 * 4`?