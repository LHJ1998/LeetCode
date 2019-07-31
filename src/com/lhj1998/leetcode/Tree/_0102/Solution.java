package com.lhj1998.leetcode.Tree._0102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        res.add(Arrays.asList(root.val));
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root.left != null) queue.offer(root.left);
        if(root.right != null) queue.offer(root.right);
        while(queue.size() > 0){
            //记录当前队列的最后一个元素
            TreeNode tail = queue.peekLast();
            List<Integer> temp = new ArrayList<>();
            while(true){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                temp.add(node.val);
                if(node == tail) break;
            }
            res.add(temp);
        }
        return res;
    }

}
