package com.lhj1998.leetcode.Tree._0094;

import java.util.List;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        return res;
    }

    private void inorder(List<Integer> res, TreeNode root){
        if(null == root) return;
        inorder(res, root.left);
        res.add(root.val);
        inorder(res, root.right);
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> res = new ArrayList<>();
//        TreeNode curr = root;
//        while(curr != null || !stack.isEmpty()){
//            while(curr != null){
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
//    }

}
