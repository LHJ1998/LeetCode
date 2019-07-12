package com.lhj1998.leetcode.Array._0062;

public class Solution {

//    public int uniquePaths(int m, int n) {
//        return dfs(m - 1, n - 1, 0);
//    }
//
//    private int dfs(int m, int n, int count){
//        if(m == 0 && n == 0){
//            return ++count;
//        }
//        if(n > 0){
//            //右走
//            count = dfs(m, n - 1, count);
//        }
//        if(m > 0){
//            //下走
//            count = dfs(m - 1, n, count);
//        }
//        return count;
//    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++) matrix[i][0] = 1;
        for(int i = 0; i < n; i++) matrix[0][i] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

}
