package com.lhj1998.leetcode.Tree._0109;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return (Math.abs(deepth(root.left) - deepth(root.right)) <= 1) &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private int deepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(deepth(root.left), deepth(root.right)) + 1;
    }

}
