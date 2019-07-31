# [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

 

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

 

**Note:**
Bonus points if you could solve it both recursively and iteratively.

## 思路0

判断一棵树是不是镜像树，很简单啊，只要左子树和右子树的节点相等就好啦

```java
package com.lhj1998.leetcode.Tree._0101;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    
}

```

## 思路1

也可以用非递归的解法

```java
package com.lhj1998.leetcode.Tree._0101;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);
        while(!list.isEmpty()) {
            TreeNode left = list.poll();
            TreeNode right = list.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            list.add(left.left);
            list.add(right.right);
            list.add(left.right);
            list.add(right.left);
        }
        return true;
    }

}

```

