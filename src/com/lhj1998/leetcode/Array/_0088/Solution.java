package com.lhj1998.leetcode.Array._0088;

public class Solution {

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int index1 = 0, index2 = 0;
//        for(int i = 0; i < n; i++){
//            while(index1 < m && nums1[index1] <= nums2[i]) index1++;
//            for(int j = nums1.length - 1; j > index1; j--){
//                nums1[j] = nums1[j - 1];
//            }
//            nums1[index1] = nums2[i];
//            m++;
//        }
//    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = nums1.length - 1; i >= 0 && n > 0; i--){
            if(m - 1 < 0){
                nums1[i] = nums2[n - 1];
                n--;
            }else if(nums1[m - 1] >= nums2[n - 1]){
                nums1[i] = nums1[m - 1];
                m--;
            }else{
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

}
