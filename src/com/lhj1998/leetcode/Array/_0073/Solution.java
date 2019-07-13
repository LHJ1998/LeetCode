package com.lhj1998.leetcode.Array._0073;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        //置零操作
        for(Integer row : rows){
            for(int i = 0; i < n; i++) matrix[row][i] = 0;
        }
        for(Integer col : cols){
            for(int i = 0; i < m; i++) matrix[i][col] = 0;
        }
    }

}
