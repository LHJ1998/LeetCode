package com.lhj1998.leetcode.Tree._0145;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root == null) return res;
//        postorder(root, res);
//        return res;
//    }
//
//    private void postorder(TreeNode root, List<Integer> res){
//        if(root == null) return;
//        postorder(root.left, res);
//        postorder(root.right, res);
//        res.add(root.val);
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while(stack.size() > 0){
            TreeNode node = stack.peek();
            if(node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                continue;
            }
            if(node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
                continue;
            }
            TreeNode top = stack.pop();
            visited.add(top);
            res.add(top.val);
        }
        return res;
    }

}
