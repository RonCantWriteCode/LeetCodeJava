### 题目描述
538.把二叉搜索树转换为累加树

给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

 

例如：
```
输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
```


### 题解

#### 算法1 递归 O(n)

递归右中左遍历树，依次累计得到结果。时间复杂度O(n)

```$java
/**
 * 递归 O(n)
 * @param root
 * @return
 */
public TreeNode convertBST(TreeNode root) {
    convertWithNumber(root, 0);
    return root;
}

public int convertWithNumber(TreeNode root, int n) {
    if (root == null) {
        return n;
    }
    // 右中左的中序遍历
    int rightValue = convertWithNumber(root.right, n);
    root.val += rightValue;
    int leftValue = convertWithNumber(root.left, root.val);
    // 最后一个遍历的左子节点的值，返回给下一层
    return leftValue;
}
```