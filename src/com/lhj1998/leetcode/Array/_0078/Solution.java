package com.lhj1998.leetcode.Array._0078;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        dfs(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> res, List<Integer> temp){
        for(int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new ArrayList<Integer>(temp));
            dfs(i + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
