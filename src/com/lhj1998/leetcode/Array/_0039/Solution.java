package com.lhj1998.leetcode.Array._0039;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index){
        //类似截木棍的做法，如果木棍截到0了，就是满足条件的序列 加入进去
        if(target == 0) res.add(new ArrayList<>(temp));
        else{
            //为了避免出现重复的结果 需要至少从index位置（即上一个遍历满足条件的位置开始）
            for(int i = index; i < candidates.length; i++){
                if(candidates[i] > target) continue;
                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, temp, i);
                //将最后一个加入进去的条件去除 重新寻找合适的条件
                temp.remove(temp.size() - 1);
            }
        }
    }

}
