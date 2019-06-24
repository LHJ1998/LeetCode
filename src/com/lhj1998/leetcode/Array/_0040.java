package com.lhj1998.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    //整个数组按照从小到大的顺序排序
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index){
        if(target == 0) res.add(new ArrayList<>(temp));
        else{
            for(int i = index; i < candidates.length; i++){
                if(candidates[i] > target) break;   //剪枝操作 如果i位置已经大于target了，那么后面的也一定会大于target，没有必要继续判断下去
                if(i > index && candidates[i] == candidates[i - 1]) continue;       //剪枝操作，如果前面的那个数已经和当前这个数相同，那么一定会得出一个和之前出现过的相同的结果集，需要排除这种结果集
                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, temp, i + 1);  //避免出现重复的结果集 需要从当前位置的下一个位置开始遍历
                temp.remove(temp.size() - 1);
            }
        }
    }

}
