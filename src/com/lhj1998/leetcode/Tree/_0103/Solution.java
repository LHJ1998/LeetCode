package com.lhj1998.leetcode.Tree._0103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, result, 0);
        return result;
    }

    public void zigzagLevelOrder(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size()-1 < level) result.add(new LinkedList<Integer>());

        if (level % 2 == 0) {
            ((LinkedList<Integer>) result.get(level)).addLast(node.val);
        } else {
            ((LinkedList<Integer>) result.get(level)).addFirst(node.val);
        }

        zigzagLevelOrder(node.left, result, level+1);
        zigzagLevelOrder(node.right, result, level+1);
    }

}
