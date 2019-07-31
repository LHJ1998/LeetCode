package com.lhj1998.leetcode.Tree._0095;

import java.util.ArrayList;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        //二分搜索树的一个特点是，左节点的值一定会小于根节点的值
        //所以可以不断尝试，使用较小的一段值作为左节点，较大的一段作为右节点
        if(n <= 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int low, int high){
        List<TreeNode> res = new ArrayList<>();
        if(low > high || low < 0){
            res.add(null);
            return res;
        }
        for(int i = low; i <= high; i++){
            List<TreeNode> leftTree = generateTrees(low, i - 1);
            List<TreeNode> rightTree = generateTrees(i + 1, high);
            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
