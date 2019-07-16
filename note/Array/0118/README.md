# [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)

Given a non-negative integer *numRows*, generate the first *numRows* of Pascal's triangle.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)
In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**

```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## 思路0

这个题目看着也不难，毕竟是个easy题。就是说，从第三个开始，中间的数就是前面一行的两两之和而已，遍历一下就可以了

```java
package com.lhj1998.leetcode.Array._0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;
        for(int i = 0; i < numRows; i++){
            if(i == 0) res.add(Collections.singletonList(1));
            else if(i == 1) res.add(Arrays.asList(1, 1));
            else {
                List<Integer> temp = new ArrayList<>(Collections.singletonList(1));
                List<Integer> last = res.get(i - 1);
                for(int j = 1; j < last.size(); j++){
                    temp.add(last.get(j - 1) + last.get(j));
                }
                temp.add(1);
                res.add(temp);
            }
        }
        return res;
    }

}

```

效率有点低，只超过了21.28%的用户，还是有改进的地方

## 思路1

