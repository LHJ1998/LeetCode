package com.lhj1998.leetcode.Tree._0108;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(null == nums || nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, 0, mid - 1);
        root.right = buildTree(nums, mid + 1, nums.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

}
