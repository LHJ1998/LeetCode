# [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

Given inorder and postorder traversal of a tree, construct the binary tree.

**Note:**
You may assume that duplicates do not exist in the tree.

For example, given

```
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
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

这题目和 [Construct Binary Tree from Preorder and Inorder Traversal](note/Array/0105/README.md) 的区别就是前面的是给出先序遍历和中序遍历，这个给的是中序遍历和后序遍历，其实做法都是一样的，也是找中序遍历和后序遍历的规律就可以做出来了

```java
package com.lhj1998.leetcode.Array._0106;

public class Solution {

    private int postEnd;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null == inorder || inorder.length == 0
                || null == postorder || postorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        postEnd = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if(postEnd < 0 || inStart > inEnd) return null;
        int val = postorder[postEnd--];
        TreeNode root = new TreeNode(val);
        if(inStart == inEnd) return root;
        int rootIndex = map.get(val);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, map);
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, map);
        return root;
    }
    
}

```

