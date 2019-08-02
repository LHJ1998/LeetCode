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
