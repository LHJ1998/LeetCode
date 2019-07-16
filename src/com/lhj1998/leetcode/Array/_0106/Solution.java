package com.lhj1998.leetcode.Array._0106;

public class Solution {

    private int postEnd;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null == inorder || inorder.length == 0
                || null == postorder || postorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        postEnd = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(postEnd < 0 || inStart > inEnd) return null;
        int val = postorder[postEnd--];
        TreeNode root = new TreeNode(val);
        if(inStart == inEnd) return root;
        int rootIndex = map.get(val);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, map);
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, map);
        return root;
    }

}
