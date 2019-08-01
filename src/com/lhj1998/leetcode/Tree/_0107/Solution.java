package com.lhj1998.leetcode.Tree._0107;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    private void levelOrderBottom(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        if(res.size() <= level) res.add(new LinkedList<>());
        ((LinkedList)res.get(level)).addLast(root.val);
        levelOrderBottom(root.left, res, level + 1);
        levelOrderBottom(root.right, res, level + 1);
    }

}
