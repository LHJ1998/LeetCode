package com.lhj1998.leetcode.Array._0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(null == matrix || matrix.length == 0) return new ArrayList<Integer>();
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols -1;
        List<Integer> res = new ArrayList<>();
        while(left <= right && top <= bottom){
            //右移
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            //下移
            for(int j = top + 1; j <= bottom; j++){
                res.add(matrix[j][right]);
            }
            if(left < right && top < bottom){
                //左移
                for(int i = right - 1; i > left; i--){
                    res.add(matrix[bottom][i]);
                }
                //上移
                for(int j = bottom; j > top; j--){
                    res.add(matrix[j][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return res;
    }

}
