# [Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling `next()` will return the next smallest number in the BST.

 



**Example:**

**![img](https://assets.leetcode.com/uploads/2018/12/25/bst-tree.png)**

```
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
```

 

**Note:**

- `next()` and `hasNext()` should run in average O(1) time and uses O(*h*) memory, where *h* is the height of the tree.
- You may assume that `next()` call will always be valid, that is, there will be at least a next smallest number in the BST when `next()` is called.

## 思路0

二分搜索树的中序遍历就是结果了，初始化的时候把中序遍历弄好就可以了

```java
class BSTIterator {
    
    private LinkedList<Integer> list = null;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        inorder(root, list);
    }
    
    /** @return the next smallest number */
    public int next() {
        return list.poll();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list.size() > 0;
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
```

