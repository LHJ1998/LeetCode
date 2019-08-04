package com.lhj1998.leetcode.Greedy._0406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {

//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, (p1, p2) -> {
//            //按照身高排序，如果身高一样，那么按照k排序
//            //最后排序结果是，高的在前面，k小的在前面
//            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
//        });
//        LinkedList<int[]> list = new LinkedList<>();
//        for(int[] p : people){
//            //将p插入到第k个位置上去
//            list.add(p[1], p);
//        }
//        return list.toArray(new int[people.length][2]);
//    }

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0)
            return new int[][]{};
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][2]);
    }

}
