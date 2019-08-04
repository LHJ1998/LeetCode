package com.lhj1998.leetcode.Greedy._0452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        if(null == points || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int res = 1, further = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= further){
                further = Math.min(further, points[i][1]);
                continue;
            }
            further = points[i][1];
            res++;
        }
        return res;
    }

}
