package com.lhj1998.leetcode.Math._0043;

public class Solution {

    public String multiply(String num1, String num2) {
        if(null == num1 || "".equals(num1) ||
                null == num2 || "".equals(num2)) return "";
        if("0".equals(num1) || "0".equals(num2)) return "0";
        //乘法最后的结果，最长就是两个数的长度之和
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        //转化成数组的形式
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        //定义一个指针指向每次累加的位置和进位
        int index = len1 + len2, temp = 0;
        for(int i = len1 - 1; i >= 0; i--){
            int num = array1[i] - '0';
            int addition = 0;
            index--;
            temp = index;
            for(int j = len2 - 1; j >= 0; j--){
                int multiply = num * (array2[j] - '0');
                int sum = multiply + addition + res[temp];
                addition = sum / 10;
                res[temp] = sum % 10;
                temp--;
            }
            if(addition != 0) res[temp] = addition;
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < res.length && res[i] == 0) i++;
        for(; i < res.length; i++){
            builder.append(res[i]);
        }
        return builder.toString();
    }

}
