# [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

Given preorder and inorder traversal of a tree, construct the binary tree.

**Note:**
You may assume that duplicates do not exist in the tree.

For example, given

```
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
```

Return the following binary tree:

```
    3
   / \
  9  20
    /  \
   15   7
```

## 思路0

这个题目就是要通过二叉树的先序遍历和中序遍历构造出二叉树而已

先序遍历就是从左往右的一个遍历，因此每次添加的节点的值都是preorder

然后再根据先序遍历和中序遍历的规律，找到中序遍历的范围

重复上面的步骤就可以解题了

```java
package com.lhj1998.leetcode.Tree._0105;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || preorder.length == 0
                || null == inorder || inorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if(preStart > preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = 0;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
        root.right = buildTree(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd);
        return root;
    }
    
}

```

这个时间稍微花的长了一点，上面的代码主要性能消耗在查找`rootIndex`的循环上面，如果一开始就记住这个位置的话应该会快一点

```java
package com.lhj1998.leetcode.Tree._0105;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || preorder.length == 0
                || null == inorder || inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> map){
        if(preStart > preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]);
        root.left = buildTree(preorder, inorder, preStart + 1, inStart, rootIndex - 1, map);
        root.right = buildTree(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, map);
        return root;
    }

}

```

改过的代码比之前的性能好了一点，可以稳定在 2ms