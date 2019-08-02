package com.lhj1998.leetcode.Tree._0113;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        findPath(root, sum, res, new ArrayList<>());
        return res;
    }

    private void findPath(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
        if(root == null) return;
        if(sum == root.val && root.left == null && root.right == null){
            res.add(new ArrayList<>(temp));
            res.get(res.size() - 1).add(root.val);
            return;
        }
        temp.add(root.val);
        findPath(root.left, sum - root.val, res, temp);
        findPath(root.right, sum - root.val, res, temp);
        temp.remove(temp.size() - 1);
    }

}
