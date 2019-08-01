package com.lhj1998.leetcode.Tree._0111;

public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right == null){
            return 1 + minDepth(root.left);
        }
        if(root.left == null && root.right != null){
            return 1 + minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.right),minDepth(root.left));

    }

}
