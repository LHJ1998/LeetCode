# [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

Given a binary tree, imagine yourself standing on the *right* side of it, return the values of the nodes you can see ordered from top to bottom.

**Example:**

```
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

## 思路0

这道题理解了以后就不难了，这个题目，对于同一层的节点来说，如果有右节点，那么肯定就是看到右节点的，如果没有右节点，就让左节点上

所以可以用一个队列记录每一层的节点，然后先判断有没有左节点，有的话看到的就是左节点，这里一定要先看左节点，因为如果先看右节点，那么可能到时候有左节点，就会把右节点覆盖了...

```java
package com.lhj1998.leetcode.Tree._0199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1, curr = 0;
        while(curr++ < level){
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            if(curr == level){
                level = queue.size();
                res.add(node.val);
                curr = 0;
            }
        }
        return res;
    }
    
}

```

