package com.lhj1998.leetcode.Array._0074;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n - 1]){
                return binarySearch(matrix[i], target, 0, n - 1);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] array, int target, int left, int right){
        if(left <= right){
            int mid = ( left + right ) / 2;
            if(array[mid] == target) return true;
            if(array[mid] > target) return binarySearch(array, target, left, mid - 1);
            else return binarySearch(array, target, mid + 1, right);
        }else{
            return false;
        }
    }

}
