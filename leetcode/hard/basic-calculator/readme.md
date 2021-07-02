# Basic Calculator

## Problem statement:
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

## Examples:
```py
Input: s = "1 + 1"
Output: 2
```
```py
Input: s = " 2-1 + 2 "
Output: 3
```
```py
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
```
```py
Input: s = "+48 + -48"
Output: 0
Explanation: Numbers can have multiple digits and start with +/-.
```

## Constraints:
- 1 <= s.length <= 3 * 10^5
- s consists of digits, '+', '-', '(', ')', and ' '.
- s represents a valid expression.
- Every number and running calculation will fit in a signed 32-bit integer.
