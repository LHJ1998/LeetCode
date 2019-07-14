package com.lhj1998.leetcode.Array._0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int index){
        res.add(new ArrayList<Integer>(temp));
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            dfs(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
