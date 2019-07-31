package com.lhj1998.leetcode.Tree._0098;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, new ArrayList<Integer>());
    }

    private boolean isValidBST(TreeNode root, List<Integer> list){
        if(root != null){
            boolean validLeft = isValidBST(root.left, list);
            if(!validLeft) return false;
            if(list.size() > 0 && root.val <= list.get(list.size() - 1)) return false;
            list.add(root.val);
            return isValidBST(root.right, list);
        }
        return true;
    }

}
