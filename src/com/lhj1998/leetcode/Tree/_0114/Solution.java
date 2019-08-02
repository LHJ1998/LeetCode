package com.lhj1998.leetcode.Tree._0114;

import java.util.LinkedList;

public class Solution {

    public void flatten(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        stack.push(root);
        while(stack.size() > 0){
            TreeNode node = stack.pop();
            if(prev != null) prev.right = node;
            prev = node;
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            node.left = null;
            node.right = null;
        }
    }

}
