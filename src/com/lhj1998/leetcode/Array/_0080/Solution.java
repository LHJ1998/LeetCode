package com.lhj1998.leetcode.Array._0080;

public class Solution {

//    public int removeDuplicates(int[] nums) {
//        if(null == nums || nums.length == 0) return 0;
//        int len = nums.length;
//        for(int i = 0, j = 2; j < len; i++, j++){
//            if(nums[i] == nums[j]){
//                for(int k = j; k < len; k++){
//                    nums[k - 1] = nums[k];
//                }
//                i--;
//                j--;
//                len--;
//            }
//        }
//        return len;
//    }

//    public int removeDuplicates(int[] nums) {
//        if(null == nums || nums.length == 0) return 0;
//        int len = nums.length, count = 1;
//        for(int i = 1; i < len; i++){
//            if(nums[i - 1] == nums[i]) count++;
//            else if(count > 2){
//                int t = count - 2;
//                count = 1;
//                for(int j = i; j < len; j++){
//                    nums[j - t] = nums[j];
//                }
//                i -= t;
//                len -= t;
//            }else{
//                count = 1;
//            }
//        }
//        //清尾
//        if(count > 2){
//            len = len - (count - 2);
//        }
//        return len;
//    }

    public int removeDuplicates(int[] nums) {
        int count = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[count - 2]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }

}
