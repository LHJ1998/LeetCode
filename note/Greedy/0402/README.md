# [Remove K Digits](https://leetcode.com/problems/remove-k-digits/)

Given a non-negative integer *num* represented as a string, remove *k* digits from the number so that the new number is the smallest possible.

**Note:**

- The length of *num* is less than 10002 and will be ≥ *k*.
- The given *num* does not contain any leading zero.



**Example 1:**

```
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
```



**Example 2:**

```
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
```



**Example 3:**

```
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
```

## 思路0

这个题目的解法就是，尽可能删前面的，尽可能删大的数，就是这样

```java
package com.lhj1998.leetcode.Greedy._0402;

import java.util.LinkedList;

public class Solution {

    public String removeKdigits(String num, int k) {
        if(k <= 0) return num;
        LinkedList<Integer> stack = new LinkedList<>();
        for(char ch : num.toCharArray()){
            int val = ch - '0';
            //尽可能删大的数 尽可能删前面的数
            while(stack.size() > 0 && stack.peek() > val && k-- > 0){
                stack.pop();
            }
            stack.push(val);
        }
        while(k-- > 0) stack.pop();

        StringBuilder b = new StringBuilder();
        while(stack.size() > 0){
            b.append(stack.pop());
        }
        String res = b.reverse().toString();
        if(res.length() == 0) return "0";
        for(int i = 0; i < res.length(); i++){
            if(res.charAt(i) != '0') {
                return res.substring(i);
            }
        }
        return "0";
    }

}

```

