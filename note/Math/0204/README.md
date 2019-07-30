# [Count Primes](https://leetcode.com/problems/count-primes/)

Count the number of prime numbers less than a non-negative number, **n**.

**Example:**

```
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
```

## 思路0

这题目就是找素数啊，我记得我大一的时候还用C语言写过找素数的...

果然这种办法效率低的一匹...576ms  关键是大一书上也是这么教的，是书的锅..hhh

```java
package com.lhj1998.leetcode.Math._0204;

public class Solution {

    public int countPrimes(int n) {
        int res = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
}

```

## 思路1

可以这么想，假如第i个位置是一个素数，那么从j开始的每一个i * j位置就肯定不是一个素数，至少可以分解成i * j（j != 1）

12ms 巨大的进步...

```java
package com.lhj1998.leetcode.Math._0204;

public class Solution {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int res = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                res++;
                for(int j = 2; i * j <= n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }

}

```

## 思路2

0ms的大佬就看不懂了，我觉得我可以做出12ms的就已经很优秀了，hhh

```java
class Solution {
  public int countPrimes(int n) {
    if(n == 499979) return(41537);
    if(n == 999983) return(78497);
    if(n == 1500000) return(114155);
    if (n < 2) {
      return 0;
    }
    boolean[] a = new boolean[n];
    int c = n;
    int sqr = 4;
    for (int i = 2; sqr < n; i++, sqr = i * i) {
      if (!a[i]) {
        for (int j = sqr; j < n; j += i) {
          if (!a[j]) {
            c--;
            a[j] = true;
          }
        }
      }
    }
    return c - 2;
  }
}
```

