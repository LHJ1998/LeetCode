package com.lhj1998.leetcode.Tree._0144;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root == null) return res;
//        preorder(root, res);
//        return res;
//    }
//
//    private void preorder(TreeNode root, List<Integer> res){
//        if(root == null) return;
//        res.add(root.val);
//        preorder(root.left, res);
//        preorder(root.right, res);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(node != null || stack.size() > 0){
            while(node != null){
                stack.push(node);
                res.add(node.val);
                node = node.left;
            }
            if(stack.size() > 0){
                node = stack.pop().right;
            }
        }
        return res;
    }

}
