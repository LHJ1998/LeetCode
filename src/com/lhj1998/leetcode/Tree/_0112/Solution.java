package com.lhj1998.leetcode.Tree._0112;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(null == root) return false;
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum){
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null) return true;
        return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }

}
