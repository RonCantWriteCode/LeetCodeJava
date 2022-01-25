### 题目描述
543. 二叉树的直径

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

示例 :

给定二叉树

```
          1
         / \
        2   3
       / \     
      4   5    
```

返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。

### 题解 O(n)

本质还是求二叉树的最大深度。节点的最大直径=左子节点的最大深度+右子节点的最大深度。递归查询树各个节点的最大深度，使用全局变量存储最大的直径。时间复杂度O(n)。

```$java
private int maxDiameter;

public int diameterOfBinaryTree(TreeNode root) {
    maxDiameter = 0;
    maxDdepth(root);
    return maxDiameter;
}

private int maxDdepth(TreeNode node) {
    if (node == null) {
        return 0;
    }
    // 左儿子为根的子树的深度
    int L = maxDdepth(node.left);
    // 右儿子为根的子树的深度
    int R = maxDdepth(node.right);
    // 计算最大直径
    maxDiameter = Math.max(maxDiameter, L+R);
    // 返回该节点为根的子树的深度
    return Math.max(L, R) + 1;
}
```

