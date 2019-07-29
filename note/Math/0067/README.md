# [Add Binary](https://leetcode.com/problems/add-binary/)

Given two binary strings, return their sum (also a binary string).

The input strings are both **non-empty** and contains only characters `1` or `0`.

**Example 1:**

```
Input: a = "11", b = "1"
Output: "100"
```

**Example 2:**

```
Input: a = "1010", b = "1011"
Output: "10101"
```

## 思路0

就是一个加法而已，按照加法的规则一步一步来就行了

不过似乎效率不高，用了2ms

看了一下别人的，感觉自己傻了，因为每次加是从最后一个向前的，然后每次应该放在最后一个

所以我就每次insert到0位置，但是这样会导致数组移位操作，很耗时间，为什么我就不能直接放在后面，然后最后逆转一下呢.....果然是傻了

改了之后就是1ms了...

```java
package com.lhj1998.leetcode.Math._0067;

public class Solution {

    public String addBinary(String a, String b) {
        if(null == a || "".equals(a) || null == b || "".equals(b)) return null;
        char[] array1 = a.toCharArray(), array2 = b.toCharArray();
        int i = array1.length - 1, j = array2.length - 1;
        int val1, val2, flag = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 || j >= 0){
            val1 = i >= 0 ? array1[i] - '0' : 0;
            val2 = j >= 0 ? array2[j] - '0' : 0;
            i--;j--;
            int sum = val1 + val2 + flag;
            flag = sum / 2;
            //builder.insert(0, sum % 2);
            buidler.append(sum % 2);
        }
        //if(flag != 0) builder.insert(0, flag);
        if(flag != 0) builder.append(flag);
        //return builder.toString();
    	return builder.reverse().toString();
    }

}

```

