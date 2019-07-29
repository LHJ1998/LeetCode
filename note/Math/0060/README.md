# [Permutation Sequence](https://leetcode.com/problems/permutation-sequence/)

The set `[1,2,3,...,*n*]` contains a total of *n*! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for *n* = 3:

1. `"123"`
2. `"132"`
3. `"213"`
4. `"231"`
5. `"312"`
6. `"321"`

Given *n* and *k*, return the *k*th permutation sequence.

**Note:**

- Given *n* will be between 1 and 9 inclusive.
- Given *k* will be between 1 and *n*! inclusive.

**Example 1:**

```
Input: n = 3, k = 3
Output: "213"
```

**Example 2:**

```
Input: n = 4, k = 9
Output: "2314"
```

## 思路0

一开始想到的是先列出所有的排列，然后找到第k个，不过预料之中的超时了

```java
class Solution {
    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList();
        int[] nums = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 1; i <= n; i++) nums[i - 1] = i;
        getPermutations(nums, visited, new ArrayList<Integer>(), res);
        return res.get(k - 1);
    }
    
    private void getPermutations(int[] nums, boolean[] visited, List<Integer> temp, List<String> res){
        if(temp.size() == nums.length){
            StringBuilder b = new StringBuilder();
            for(Integer num : temp) b.append(num);
            String str = b.toString();
            if(!res.contains(str)) res.add(str);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            getPermutations(nums, visited, temp, res);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
```

## 思路1

查了一下资料，这题目要用**康托展开**来求

`X=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[1]*0!`

公式可能有点看不懂，结合例子来看就会简单一点了

- 第一种情况，求第k个全排列

比如说，给出的n是5，然后要找第16个全排列

1. 首先，第16个全排列，那么前面就应该有15个全排列存在
2. `15 / 4! = 0   -->  意味着，第一位之后有0个数比它小，这个数只可能是1`
3. 接着用上面的余数 15 继续向下
4. `15 / 3! = 2  -->  意味着，第二位之后有2个数比它小，那么就是4了`
5. 重复上述步骤，直到阶乘为0
6. 结果 1 4 3 5 2

- 第二种情况，已知全排列，求是第几个

比如说，已知全排列是34152，求这是第几个全排列

1. 首先第一个数是3，那么比3小的数是1和2，一共2个，所以a[5] = 2
2. 然后第二个数是4，那么比4小的数是1、2、3，但是因为3已经算过了，所以这里a[4] = 2
3. 接着是1，比1小的没有，那么a[3] = 0
4. 依次类推，a[2] = 1，a[1] = 0
5. 然后开始套公式 `X=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[1]*0!`
6. X = 2 * 4! + 2 * 3! + 0 * 2! + 1 * 1! + 0 * 0! = 61
7. 所以这个全排列是第62个

第一种全排列的代码，也就是本题目的解题代码

```java
package com.lhj1998.leetcode.Math._0060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        return getPermutation(n, k - 1, new ArrayList<>(), new boolean[n]);
    }

    private String getPermutation(int n, int k, List<Integer> temp, boolean[] visited){
        if(n == 0) {
            StringBuilder b = new StringBuilder();
            for(Integer num : temp){
                b.append(num);
            }
            return b.toString();
        }
        int factorial = getFactorial(n - 1);
        int num = k / factorial;
        for(int j = 1; j <= visited.length; j++){
            if(!visited[j - 1]){
                if(num == 0){
                    visited[j - 1] = true;
                    temp.add(j);
                    break;
                }
                num--;
            }
        }
        //找到比num小
        return getPermutation(n - 1, k % factorial, temp, visited);
    }

    private int getFactorial(int n){
        if(n == 0 || n == 1) return 1;
        return n * getFactorial(n - 1);
    }

}

```

第二种，已知全排列，求第几个的问题

```java
package com.lhj1998.leetcode.Math._0060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int getPosition(String str, int n){
        return getPosition(str.toCharArray(), new boolean[n], 0, 0, n);
    }

    private int getPosition(char[] array, boolean[] visited, int index, int pos, int n){
        if(n == 0) return pos;
        int num = array[index] - '0';
        visited[num - 1] = true;
        int count = 0;
        for(int i = 1; i < num; i++){
            if(!visited[i - 1]){
                count++;
            }
        }
        pos = pos + count * getFactorial(n - 1);
        return getPosition(array, visited, index + 1, pos, n - 1);
    }

    private int getFactorial(int n){
        if(n == 0 || n == 1) return 1;
        return n * getFactorial(n - 1);
    }

}

```

