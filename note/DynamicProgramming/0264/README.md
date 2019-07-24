# [Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)

Write a program to find the `n`-th ugly number.

Ugly numbers are **positive numbers** whose prime factors only include `2, 3, 5`. 

**Example:**

```
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
```

**Note:**  

1. `1` is typically treated as an ugly number.
2. `n` **does not exceed 1690**.

## 思路0

这道题简单的解法就是找到每一个ugly number，然后返回那个数就可以了。

身为一个ugly number，必须要满足的条件就是 `Ugly numbers are **positive numbers** whose prime factors only include `2, 3, 5`. ` ,一开始我认为的是，这个数的因素包含2或3或5，但是这么认为是错的，因为如果按照这样想的话，第11就应该是14才对吧，但实际上是15，因为14的一个因素7不能分解为2 3 5中的任意一个

一个数的因素可以分解成2 3 5这样最小的因素，那么肯定是一开始就从最小的数 `1` 开始就不停的 X ` 2 3 5` 这样最后才可以分解成这三个数才对，比如15，就是从1开始乘以3，乘以5得到的。

从给定的序列来看，是一个升序的序列，那么每次只取最小的那个就好了

```java
package com.lhj1998.leetcode.DynamicProgramming._0264;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int nthUglyNumber(int n) {
        List<Integer> store = new ArrayList<>(Collections.singletonList(1));
        int i2 = 0, i3 = 0, i5 = 0;
        while(store.size() != n){
            int temp2 = store.get(i2) * 2;
            int temp3 = store.get(i3) * 3;
            int temp5 = store.get(i5) * 5;
            int min = Math.min(Math.min(temp2, temp3), temp5);
            if(min == temp2) ++i2;
            if(min == temp3) ++i3;
            if(min == temp5) ++i5;
            store.add(min);
        }
        return store.get(n - 1);
    }

}

```

这样的做法虽然最终可以解决问题，但是效率上肯定是不高的 12ms 32.90%

然后我看了一下别人的做法，和我的也没什么区别啊，但是用的是数组不是List，然后我想到List会动态扩容，比较耗费时间.....

```java
package com.lhj1998.leetcode.DynamicProgramming._0264;

public class Solution {

    public int nthUglyNumber(int n) {
        if(n == 1) return 1; //加上这句就是2ms........
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for(int i = 2; i <= n; i++){
            int temp2 = dp[i2] * 2;
            int temp3 = dp[i3] * 3;
            int temp5 = dp[i5] * 5;
            int min = Math.min(Math.min(temp2, temp3), temp5);
            if(min == temp2) ++i2;
            if(min == temp3) ++i3;
            if(min == temp5) ++i5;
            dp[i] = min;
        }
        return dp[n];
    }

}

```

这段代码用了4ms时间，快了3倍...