package com.lhj1998.leetcode.Tree._0105;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if(null == preorder || preorder.length == 0
//                || null == inorder || inorder.length == 0) return null;
//        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
//    }
//
//    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
//        if(preStart > preorder.length || inStart > inEnd) return null;
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int rootIndex = 0;
//        for(int i = 0; i < inorder.length; i++){
//            if(inorder[i] == root.val){
//                rootIndex = i;
//                break;
//            }
//        }
//        root.left = buildTree(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
//        root.right = buildTree(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd);
//        return root;
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || preorder.length == 0
                || null == inorder || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart > preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]);
        root.left = buildTree(preorder, inorder, preStart + 1, inStart, rootIndex - 1, map);
        root.right = buildTree(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, map);
        return root;
    }

}
