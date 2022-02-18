### 题目描述
94.二叉树的中序遍历

给定一个二叉树的根节点 root ，返回它的 中序 遍历。

示例 1:

![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/inorderTraversal/inorder_1.jpg)

```
输入：root = [1,null,2,3]
输出：[1,3,2]
```

示例 2:

```
输入：root = []
输出：[]
```

示例 3:

```
输入：root = [1]
输出：[1]
```

示例 4:

![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/inorderTraversal/inorder_5.jpg)

```
输入：root = [1,2]
输出：[2,1]
```

示例 5:

![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/inorderTraversal/inorder_4.jpg)

```
输入：root = [1,null,2]
输出：[1,2]
```

提示:

* 树中节点数目在范围 [0, 100] 内
* -100 <= Node.val <= 100

进阶: 递归算法很简单，你可以通过迭代算法完成吗？

### 题解

#### 算法1 递归 O(n)

递归树的中序遍历，左子树，根，右子树。时间复杂度O(n)。

```$java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
}

private void inorder(TreeNode root, List<Integer> result) {
    if (root == null) {
        return;
    }
    inorder(root.left, result);
    result.add(root.val);
    inorder(root.right, result);
}
```

#### 算法2 迭代 O(n)

迭代需要定义一个栈（代码使用双端队列），先进后出维护后续需要遍历的各个节点。时间复杂度O(n)。

```$java
public List<Integer> inorderTraversalIterator(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
        // 遍历所有左节点，并将根存入栈中
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        result.add(root.val);
        root = root.right;
    }
    return result;
}
```