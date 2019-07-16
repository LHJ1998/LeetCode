# [Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)

Given a non-negative index *k* where *k* ≤ 33, return the *k*th index row of the Pascal's triangle.

Note that the row index starts from 0.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif)
In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**

```
Input: 3
Output: [1,3,3,1]
```

**Follow up:**

Could you optimize your algorithm to use only *O*(*k*) extra space?

## 思路0

和 [Pascal's Triangle](note/Array/0118/README.md) 是一样的，可以模拟这个过程，然后得出结果，题目最后的提示说不要用额外的空间，然后就出了这种解法

```java
package com.lhj1998.leetcode.Array._0119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            if(i == 0){
                res = new ArrayList<>(Collections.singletonList(1));
                continue;
            }
            if(i == 1){
                res = new ArrayList<>(Arrays.asList(1, 1));
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < res.size(); j++){
                temp.add(res.get(j - 1) + res.get(j));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }

}

```

