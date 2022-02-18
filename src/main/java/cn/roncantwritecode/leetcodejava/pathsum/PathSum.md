### 题目描述
437.路径总和 III

给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例:
```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
```

### 题解

#### 算法1 递归 O(n*log(n))

递归树，判断已当前节点为结束节点的满足总数的路径和，使用array记录根节点到当前节点的路径，depth记录当前节点的深度，路径和只需要逆序相加即可判断。

遍历整棵树时间复杂度为O(n).每个节点遍历array路径，平均路径长度是log(n)。所以时间复杂度O(n*log(n))


```$java
/**
 * 递归 O(n*log(n))
 * @param root
 * @param sum
 * @return
 */
public int pathSum(TreeNode root, int sum) {
    return pathSumRecursive(root, sum, new int[1000], 0);
}

private int pathSumRecursive(TreeNode root, int sum, int[] array, int depth) {
    if (root == null) {
        return 0;
    }

    array[depth] = root.val;
    int result = 0;
    int temp = 0;
    for (int i = depth; i >= 0; i--) {
        temp += array[i];
        if (temp == sum) {
            result++;
        }
    }
    int resultLeft = pathSumRecursive(root.left, sum, array, depth + 1);
    int resultRight = pathSumRecursive(root.right, sum, array, depth + 1);
    return result + resultLeft + resultRight;
}
```