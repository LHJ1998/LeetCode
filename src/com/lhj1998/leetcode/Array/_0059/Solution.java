package com.lhj1998.leetcode.Array._0059;

public class Solution {

    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][0];
        int[][] res = new int[n][n];
        int currNum = 1, top = 0, bottom = n - 1, left = 0, right = n - 1;
        while(currNum < n * n){
            //右遍历
            for(int i = left; i <= right; i++){
                res[top][i] = currNum++;
            }
            //下遍历
            for(int i = top + 1; i <= bottom; i++){
                res[i][right] = currNum++;
            }
            if(top < bottom && left < right){
                //左遍历
                for(int i = right - 1; i > left; i--){
                    res[bottom][i] = currNum++;
                }
                //上遍历
                for(int i = bottom; i > top; i--){
                    res[i][left] = currNum++;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        if(n % 2 != 0) res[n / 2][n / 2] = n * n;
        return res;
    }

}
