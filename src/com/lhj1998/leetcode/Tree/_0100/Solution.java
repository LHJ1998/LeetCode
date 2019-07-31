package com.lhj1998.leetcode.Tree._0100;

public class Solution {

//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        String str1 = preOrder(p, new StringBuilder()).toString();
//        String str2 = preOrder(q, new StringBuilder()).toString();
//        return str1.equals(str2);
//    }
//
//    private StringBuilder preOrder(TreeNode root, StringBuilder builder) {
//        if (root != null) {
//            builder.append(root.val);
//            builder = preOrder(root.left, builder);
//            return preOrder(root.right, builder);
//        }else {
//            builder.append("null");
//            return builder;
//        }
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果两棵树相同，那么左子树可右子树也是相同的
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
