# [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

Given a binary tree, return the *level order* traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```



return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```

## 思路0

题目的意思是，把同一层的节点返回

好像也不难的样子...，可以把每个节点入队列，然后同层节点出队列就好了

```java
package com.lhj1998.leetcode.Tree._0102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        res.add(Arrays.asList(root.val));
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root.left != null) queue.offer(root.left);
        if(root.right != null) queue.offer(root.right);
        while(queue.size() > 0){
            //记录当前队列的最后一个元素
            TreeNode tail = queue.peekLast();
            List<Integer> temp = new ArrayList<>();
            while(true){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                temp.add(node.val);
                if(node == tail) break;
            }
            res.add(temp);
        }
        return res;
    }
    
}

```

## 思路1

可以用递归，但是自己没有想出来...

1ms

```java
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    levelOrderCore(root, 1, result);
    return result;
  }
  
  private void levelOrderCore(TreeNode root, int level, List<List<Integer>> result) {
    if (root == null) return;
    if (result.size() < level) {
      result.add(new ArrayList<Integer>());
    }
    result.get(level - 1).add(root.val);
    levelOrderCore(root.left, level + 1, result);
    levelOrderCore(root.right, level + 1, result);
  }
}
```

0ms

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        levelOrderHelper(root, list, 0);
        return list;
    }
    public void levelOrderHelper(TreeNode node, List<List<Integer>> list, int level) {
        if(node == null) return;
        if(list.size() == level) list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        levelOrderHelper(node.left, list, level+1);
        levelOrderHelper(node.right, list, level+1);
    }
}
```

