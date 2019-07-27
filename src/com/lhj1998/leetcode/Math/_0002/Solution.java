package com.lhj1998.leetcode.Math._0002;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), curr = res;
        int flag = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

            int sum = val1 + val2 + flag;
            flag = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if(flag != 0) curr.next = new ListNode(flag);
        return res.next;
    }

}
