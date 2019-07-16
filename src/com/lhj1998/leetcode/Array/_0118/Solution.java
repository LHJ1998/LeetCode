package com.lhj1998.leetcode.Array._0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;
        for(int i = 0; i < numRows; i++){
            if(i == 0) res.add(Collections.singletonList(1));
            else if(i == 1) res.add(Arrays.asList(1, 1));
            else {
                List<Integer> temp = new ArrayList<>(Collections.singletonList(1));
                List<Integer> last = res.get(i - 1);
                for(int j = 1; j < last.size(); j++){
                    temp.add(last.get(j - 1) + last.get(j));
                }
                temp.add(1);
                res.add(temp);
            }
        }
        return res;
    }

}
