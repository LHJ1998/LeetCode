package com.lhj1998.leetcode.Array._0056;

public class Solution {

    public int[][] merge(int[][] intervals) {
        int rows = intervals.length;
        if(rows == 1) return intervals;
        int[][] temp = new int[rows][2];
        int index = 0;
        sort(intervals);
        for(int i = 0; i < rows; i++){
            if(i == 0){
                temp[0][0] = intervals[0][0];
                temp[0][1] = intervals[0][1];
                index++;
                continue;
            }
            int preStart = temp[index - 1][0];
            int preEnd = temp[index - 1][1];
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            //两者是否有交集
            if(isOverlapping(preStart, preEnd, currStart, currEnd)){
                int start = Math.min(preStart, currStart);
                int end = Math.max(preEnd, currEnd);
                temp[index - 1][0] = start;
                temp[index - 1][1] = end;
            }else{
                temp[index][0] = currStart;
                temp[index][1] = currEnd;
                index++;
            }
        }
        int[][] res = new int[index][2];
        for(int i = 0; i < index; i++){
            res[i][0] = temp[i][0];
            res[i][1] = temp[i][1];
        }
        return res;
    }

    private boolean isOverlapping(int preStart, int preEnd, int currStart, int currEnd){
        return (currStart >= preStart && currStart <= preEnd)
                || (preStart >= currStart && preEnd <= currEnd);
    }

    private void sort(int[][] array){
        int rows = array.length;
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < rows; j++){
                if(array[j][0] < array[i][0]){
                    //交换
                    int tempStart = array[i][0], tempEnd = array[i][1];
                    array[i][0] = array[j][0];
                    array[i][1] = array[j][1];
                    array[j][0] = tempStart;
                    array[j][1] = tempEnd;
                }
            }
        }
    }

}
