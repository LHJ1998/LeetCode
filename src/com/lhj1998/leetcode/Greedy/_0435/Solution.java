package com.lhj1998.leetcode.Greedy._0435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(null == intervals || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
                continue;
            }
            res++;
        }
        return res;
    }

}
