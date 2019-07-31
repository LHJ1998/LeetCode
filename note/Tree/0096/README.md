# [Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)

Given *n*, how many structurally unique **BST's** (binary search trees) that store values 1 ... *n*?

**Example:**

```
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

## 思路0

这....不是和 [Unique Binary Search Trees II](../0095/README.md) 完全一样吗，一个求list，一个求total...

竟然超时了我去...

```java
class Solution {
    public int numTrees(int n) {
        if(n <= 0) return 0;
        return generateTrees(1, n).size();
    }
    
    private List<TreeNode> generateTrees(int low, int high){
        List<TreeNode> res = new ArrayList<>();
        if(low > high || low < 0){
            res.add(null);
            return res;
        }
        for(int i = low; i <= high; i++){
            List<TreeNode> leftTree = generateTrees(low, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, high);
            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
```

## 思路1

用dp的做法，如果左子树和右子树不一样，那么整个搜索二叉树肯定是不一样的

```java
package com.lhj1998.leetcode.Tree._0096;

public class Solution {

    public int numTrees(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[0] = 1;
        return dp(res, n);
    }

    private int dp(int[] res, int n){
        if(res[n] != 0) return res[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            int left = i, right = n - i - 1;
            ans += dp(res, left) * dp(res, right);
        }
        res[n] = ans;
        return ans;
    }
    
}

```

```java
class Solution {
    public int numTrees(int n) {
        int[] num = new int[n+1];
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                num[i] += num[j-1]*num[i-j];
            }
        }
        return num[n];
    }
}
```

