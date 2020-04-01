### 题目描述
101.对称二叉树

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
```
    1
   / \
  2   2
   \   \
   3    3
```
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

### 题解

#### 算法1 递归 O(n)

镜像即根节点相同，左节点和右节点相同，右节点和左节点相同。递归即遍历了整个树的所有节点，时间复杂度O(n)


```$java
/**
 * 递归 O(n)
 * @param root
 * @return
 */
public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return isMirror(root.left, root.right);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
        return true;
    }
    if (t1 == null || t2 == null) {
        return false;
    }
    if (t1.val != t2.val) {
        return false;
    }
    // 左节点等于镜像的右节点
    if (!isMirror(t1.left, t2.right)) {
        return false;
    }
    // 右节点等于镜像的左节点
    if (!isMirror(t1.right, t2.left)) {
        return false;
    }
    return true;
}
```

#### 算法2 迭代 O(n)

迭代思路相同，使用栈保存数据，达到递归相同效果。时间复杂度O(n)

```$java
/**
 * 迭代 O(n)
 * @param root
 * @return
 */
public boolean isSymmetricStack(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
        return true;
    }
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.isEmpty()) {
        TreeNode t1 = stack.pop();
        TreeNode t2 = stack.pop();

        if (t1 == null && t2 == null) {
            continue;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        // 左节点等于镜像的右节点
        stack.push(t1.left);
        stack.push(t2.right);
        // 右节点等于镜像的左节点
        stack.push(t1.right);
        stack.push(t2.left);
    }

    return true;
}
```