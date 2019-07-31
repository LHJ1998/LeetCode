package com.lhj1998.leetcode.Tree._0101;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        LinkedList<TreeNode> list = new LinkedList<>();
//        list.add(root.left);
//        list.add(root.right);
//        while(!list.isEmpty()) {
//            TreeNode left = list.poll();
//            TreeNode right = list.poll();
//            if(left == null && right == null) continue;
//            if(left == null || right == null) return false;
//            if(left.val != right.val) return false;
//            list.add(left.left);
//            list.add(right.right);
//            list.add(left.right);
//            list.add(right.left);
//        }
//        return true;
//    }

}
