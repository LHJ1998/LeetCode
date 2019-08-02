# [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)

Given a binary tree containing digits from `0-9` only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path `1->2->3` which represents the number `123`.

Find the total sum of all root-to-leaf numbers.

**Note:** A leaf is a node with no children.

**Example:**

```
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```

**Example 2:**

```
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

## 思路0

很简单啊，这个题目的思路其实和之前的 [Path Sum](../0112/README.md) 和 [Path Sum II](../0113/README.md) 思路差不多

```java
package com.lhj1998.leetcode.Tree._0129;

public class Solution {

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int sum, int curr){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            curr = curr * 10 + root.val;
            sum += curr;
            return sum;
        }
        return dfs(root.left, sum, (curr * 10) + root.val) +
                dfs(root.right, sum, (curr * 10) + root.val);
    }

}

```

