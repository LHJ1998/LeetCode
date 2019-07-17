package com.lhj1998.leetcode.DynamicProgramming._0063;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][0] != 1; i++) matrix[i][0] = 1;
        for(int i = 0; i < n && obstacleGrid[0][i] != 1; i++) matrix[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1) matrix[i][j] = 0;
                else matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

}
