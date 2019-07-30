# [Happy Number](https://leetcode.com/problems/happy-number/)

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

**Example:** 

```
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

## 思路0

模拟了一下过程，但是效率不高

```java
package com.lhj1998.leetcode.Math._0202;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isHappy(int n) {
        if(n < 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        while(true){
            int temp = 0;
            while(n != 0){
                int r = n % 10;
                n = n / 10;
                temp += Math.pow(r, 2);
            }
            if(temp == 1) return true;
            if(map.containsKey(temp)) return false;
            map.put(temp, 1);
            n = temp;
        }
        // return false;
    }
    
}

```

## 思路1

看了一下别人1ms的代码

思路和我的是一样的，但是这里有一个很高明的地方就是，先把可能的平方求出来了，因为求余的时候得到的余数不可能超过10，因此这里就省掉了很多平方操作

```java
class Solution {
    public boolean isHappy(int n) {
        int[] table = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
        Set<Integer> setInt = new HashSet<Integer>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int reminder = n % 10;
                sum += table[reminder];
                n /= 10;
            }
            n = sum;
            if (setInt.contains(n)) {
                return false;
            } else {
                setInt.add(n);
            }
        }
        return true;
    }
}
```

接下来是0ms的

有差距不是没有原因的...

```java
class Solution {
    public boolean isHappy(int n) {
        
        int digit = 0;   
        while(n!=1&&n!=4){
            int totalSum = 0;
            while(n!=0){
                digit = n%10;
                totalSum += digit * digit;
                n/=10;      
            }  
            n = totalSum;
        }
        return n==1;
    }
}
```

