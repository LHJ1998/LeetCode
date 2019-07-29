package com.lhj1998.leetcode.Math._0067;

public class Solution {

    public String addBinary(String a, String b) {
        if(null == a || "".equals(a) || null == b || "".equals(b)) return null;
        char[] array1 = a.toCharArray(), array2 = b.toCharArray();
        int i = array1.length - 1, j = array2.length - 1;
        int val1, val2, flag = 0;
        StringBuilder builder = new StringBuilder();
        while(i >= 0 || j >= 0){
            val1 = i >= 0 ? array1[i] - '0' : 0;
            val2 = j >= 0 ? array2[j] - '0' : 0;
            i--;j--;
            int sum = val1 + val2 + flag;
            flag = sum / 2;
            builder.insert(0, sum % 2);
        }
        if(flag != 0) builder.insert(0, flag);
         return builder.toString();
    }

}
