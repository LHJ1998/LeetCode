# [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example:**

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

## 思路0

很简单的一道题目，只要像做加法一样就可以了，需要额外注意的就是最后的进位可能不为0

```java
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

```

