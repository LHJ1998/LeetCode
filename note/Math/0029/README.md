# [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing `dividend` by `divisor`.

The integer division should truncate toward zero.

**Example 1:**

```
Input: dividend = 10, divisor = 3
Output: 3
```

**Example 2:**

```
Input: dividend = 7, divisor = -3
Output: -2
```

**Note:**

- Both dividend and divisor will be 32-bit signed integers.
- The divisor will never be 0.
- Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

## 思路0

这道题目我觉得是不可以用除法的，然后一个数除以另一个数，其实实际上的结果不就是减了n次吗对吧，然后就用减法做呗

```java
package com.lhj1998.leetcode.Math._0029;

public class Solution {

    public int divide(int dividend, int divisor) {
        //用减法不要用除法
        if(dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        //记录是否为负数
        boolean isNagetive = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        //正数化
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        //然后每次减divisor，记录减了多少次
        int res = 0;
        while(a >= b){
            a -= b;
            res++;
        }
        return isNagetive ? -res : res;
    }

}

```

提交以后，耗时880ms，难以接受...

看了一下别人的做法，然后对比优化了一下

```java
package com.lhj1998.leetcode.Math._0029;

public class Solution {

    public int divide(int dividend, int divisor) {
        //用减法不要用除法
        if(dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        //记录是否为负数
        boolean isNagetive = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        //正数化
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        //然后每次减divisor，记录减了多少次
        int res = 0;
        while(a >= b){
            long divisor_ = b;
            long mutiply = 1;
            while(divisor_ + divisor_ <= a){
                divisor_ += divisor_;
                mutiply += mutiply;
            }
            res += mutiply;
            a -= divisor_;
        }
        return isNagetive ? -res : res;
    }

}

```

然后就1ms了，神奇