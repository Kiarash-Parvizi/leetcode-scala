# Wildcard Matching

## Problem statement:
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
- '?' Matches any single character.
- '*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

## Examples:
```py
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```
```py
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
```
```py
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```
```py
Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
```
```py
Input: s = "acdcb", p = "a*c?b"
Output: false
```

## Constraints:
- 0 <= s.length, p.length <= 2000
- s contains only lowercase English letters.
- p contains only lowercase English letters, '?' or '*'.
