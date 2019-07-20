package com.lhj1998.leetcode.DynamicProgramming._0221;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        // if(matrix[0].length == 1) return 1;
        int m = matrix.length, n = matrix[0].length, max = 0;
        for(int i= 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0') continue;
                max = Math.max(max, expand(matrix, i, j));
            }
        }
        return max;
    }

    private int expand(char[][] matrix, int x, int y){
        int area = 1, tx = x, ty = y;
        int m = matrix.length, n = matrix[0].length;
        while(x < m && y < n){
            tx++;
            ty++;
            //检测是否有0加入
            if(tx < m && ty < n && !containsZero(matrix, x, y, tx, ty)){
                area = (tx - x + 1) * (ty - y + 1);
            }else break;
        }
        return area;
    }

    private boolean containsZero(char[][] matrix, int x, int y, int tx, int ty){
        // System.out.println();
        // System.out.println("扩展: x = " + x + " y = " + y + " tx = " + tx + " ty = " + ty);
        //检测新增列ty
        for(int i = x; i <= tx; i++){
            if(matrix[i][ty] == '0') return true;
        }
        //检测新增行
        for(int i = y; i <= ty; i++){
            if(matrix[tx][i] == '0') return true;
        }
        // System.out.println("扩展未通过");
        return false;
    }

}
