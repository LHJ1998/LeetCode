package com.lhj1998.leetcode.Tree._0199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1, curr = 0;
        while(curr++ < level){
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            if(curr == level){
                level = queue.size();
                res.add(node.val);
                curr = 0;
            }
        }
        return res;
    }

}
