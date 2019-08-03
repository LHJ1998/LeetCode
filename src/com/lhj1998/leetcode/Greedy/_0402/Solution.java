package com.lhj1998.leetcode.Greedy._0402;

import java.util.LinkedList;

public class Solution {

    public String removeKdigits(String num, int k) {
        if(k <= 0) return num;
        LinkedList<Integer> stack = new LinkedList<>();
        for(char ch : num.toCharArray()){
            int val = ch - '0';
            while(stack.size() > 0 && stack.peek() > val && k-- > 0){
                stack.pop();
            }
            stack.push(val);
        }
        while(k-- > 0) stack.pop();

        StringBuilder b = new StringBuilder();
        while(stack.size() > 0){
            b.append(stack.pop());
        }
        String res = b.reverse().toString();
        if(res.length() == 0) return "0";
        for(int i = 0; i < res.length(); i++){
            if(res.charAt(i) != '0') {
                return res.substring(i);
            }
        }
        return "0";
    }

}
