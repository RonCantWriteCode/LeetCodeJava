### 题目描述
226.翻转二叉树

翻转一棵二叉树。

示例:

输入：
```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

输出：
```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```


### 题解

#### 算法1 递归 O(n)

递归二叉树的左右节点，调换左右节点位置。时间复杂度O(n)

```$java
/**
 * 递归 O(n)
 * @param root
 * @return
 */
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
}
```
