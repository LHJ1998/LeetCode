package com.lhj1998.leetcode.DynamicProgramming._0064;

public class Solution {

//    public int minPathSum(int[][] grid) {
//        return dfs(grid, 0, 0, 0, Integer.MAX_VALUE);
//    }
//
//    private int dfs(int[][] grid, int x, int y, int curr, int min){
//        curr = curr + grid[x][y];
//        if(x == grid.length - 1 && y == grid[0].length - 1){
//            min = Math.min(curr, min);
//            return min;
//        }
//        //右移
//        if(y < grid[0].length - 1){
//            min = dfs(grid, x, y + 1, curr, min);
//        }
//        if(x < grid.length - 1){
//            min = dfs(grid, x + 1, y, curr, min);
//        }
//        return min;
//    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0] = grid[0][0];
        //第一行只能从左往右走这一种路线，因此第一行的代价就是前面一个的代价和当前位置代价的和
        for(int i = 1; i < n; i++) matrix[0][i] = matrix[0][i - 1] + grid[0][i];
        //第一列同理
        for(int i = 1; i < m; i++) matrix[i][0] = matrix[i - 1][0] + grid[i][0];
        //现在计算每一个位置的最小代价
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] = Math.min(matrix[i -1][j], matrix[i][j - 1]) + grid[i][j];
            }
        }
        return matrix[m - 1][n - 1];
    }

}
