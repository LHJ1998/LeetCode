package com.lhj1998.leetcode.Array._0119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            if(i == 0){
                res = new ArrayList<>(Collections.singletonList(1));
                continue;
            }
            if(i == 1){
                res = new ArrayList<>(Arrays.asList(1, 1));
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < res.size(); j++){
                temp.add(res.get(j - 1) + res.get(j));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }

}
