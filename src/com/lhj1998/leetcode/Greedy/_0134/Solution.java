package com.lhj1998.leetcode.Greedy._0134;

public class Solution {

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        if(null == gas || gas.length == 0 ||
//                cost == null || cost.length == 0) return -1;
//        int i = 0;
//        while(i < gas.length){
//            if(gas[i] >= cost[i]){
//                int j = i, gasj = gas[i], costj = cost[i];
//                while(true){
//                    j++;
//                    if(j >= gas.length) j = j % gas.length;
//                    gasj = gasj + gas[j] - costj;
//                    costj = cost[j];
//                    if(j == i && gasj >= 0) return i;
//                    if(gasj <= 0 || gasj < costj) break;
//                }
//            }
//            i++;
//        }
//        return -1;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null == gas || gas.length == 0 ||
                cost == null || cost.length == 0) return -1;
        int sum = 0;
        for(int i = 0; i < gas.length; i++) sum = sum + gas[i] - cost[i];
        if(sum < 0) return -1;
        int start = 0, earn = 0;
        for(int i = 0; i < gas.length; i++){
            earn = earn + gas[i] - cost[i];
            if(earn < 0){
                earn = 0;
                start = i + 1;
            }
        }
        return start;
    }

}
