# [Perfect Squares](https://leetcode.com/problems/perfect-squares/)

Given a positive integer *n*, find the least number of perfect square numbers (for example, `1, 4, 9, 16, ...`) which sum to *n*.

**Example 1:**

```
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
```

**Example 2:**

```
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

## 思路0

这题目的意思就是一个数n可以分解为多个平方数的和，然后找到最少的平方数个数

既然这个数最后的分解结果一定是m个平方数的和，那么这个数n的平方数和的个数一定是`n - 某一个平方数`的平方数的和的个数 + 1才对，所以只要遍历这个平方数，找到最小的那个就可以了

```java
package com.lhj1998.leetcode.DynamicProgramming._0279;

public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i / 2; j++){
                int s = j * j;
                //超出范围了，直接退出
                if(i - s < 0) break;
                //第i个数 - 平方数以后 + 1和当前最小比较
                dp[i] = Math.min(dp[i], dp[i - s] + 1);
            }
        }
        return dp[n];
    }
    
}

```

这段代码反复试过了，时间大概都在31ms 32ms左右，实在比较慢

```java
package com.lhj1998.leetcode.DynamicProgramming._0279;

public class Solution {

    public int numSquares(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            // dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i / 2; j++){
                //超出范围了，直接退出
                int t = i - j * j;
                if(t < 0) break;
                //第i个数 - 平方数以后 + 1和当前最小比较
                dp[i] = Math.min(dp[i], dp[t] + 1);
            }
        }
        return dp[n];
    }
    
}

```

这是改进后的代码，主要是减少了赋值和计算次数，时间可以达到20ms左右

## 思路2

不过就算最后可以达到20ms，也还是很慢啊.....

看了一下，有大神的做法直接1ms搞定......

```java
class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;            
        }

        if (n % 8 == 7) {
            return 4;
        }
        
        for (int i = 0; i * i <= n; i++) {
            int j = (int)Math.sqrt(n * 1.0 - i * i);
            
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0) {
                    res += 1;                    
                }

                if (j > 0) {
                    res += 1;                    
                }

                return res;
            }
        }
        
        return 3;
    }
}
```

大神的代码不理解，看了一下别人的讲解，用到了什么四平方和定理

```txt
根据四平方和定理，任意一个正整数均可表示为4个整数的平方和，其实是可以表示为4个以内的平方数之和，那么就是说返回结果只有1,2,3或4其中的一个。将数字简化一下，一个数含有因子4，可以除去这个4，获得的结果不变。例如 12/4=3. 12的返回结果是3， 3的返回结果也是3. 还有8和2。还有一个可以简化的是如果一个数除以8余7的话，那么肯定是由4个完全平方数组成。（可以自行举例）。接下来 将正整数 拆成两个平方数之和，如果拆成功了，则返回1或者2。
```

