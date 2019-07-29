package com.lhj1998.leetcode.Math._0060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        return getPermutation(n, k - 1, new ArrayList<>(), new boolean[n]);
    }

    private String getPermutation(int n, int k, List<Integer> temp, boolean[] visited){
        if(n == 0) {
            StringBuilder b = new StringBuilder();
            for(Integer num : temp){
                b.append(num);
            }
            return b.toString();
        }
        int factorial = getFactorial(n - 1);
        int num = k / factorial;
        for(int j = 1; j <= visited.length; j++){
            if(!visited[j - 1]){
                if(num == 0){
                    visited[j - 1] = true;
                    temp.add(j);
                    break;
                }
                num--;
            }
        }
        //找到比num小
        return getPermutation(n - 1, k % factorial, temp, visited);
    }

    private int getFactorial(int n){
        if(n == 0 || n == 1) return 1;
        return n * getFactorial(n - 1);
    }

//    public int getPosition(String str, int n){
//        return getPosition(str.toCharArray(), new boolean[n], 0, 0, n);
//    }
//
//    private int getPosition(char[] array, boolean[] visited, int index, int pos, int n){
//        if(n == 0) return pos;
//        int num = array[index] - '0';
//        visited[num - 1] = true;
//        int count = 0;
//        for(int i = 1; i < num; i++){
//            if(!visited[i - 1]){
//                count++;
//            }
//        }
//        pos = pos + count * getFactorial(n - 1);
//        return getPosition(array, visited, index + 1, pos, n - 1);
//    }
//
//    private int getFactorial(int n){
//        if(n == 0 || n == 1) return 1;
//        return n * getFactorial(n - 1);
//    }

}
