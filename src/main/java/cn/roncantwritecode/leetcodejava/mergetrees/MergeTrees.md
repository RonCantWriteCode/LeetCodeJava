### 题目描述
617. 合并二叉树

给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。


示例 1：


```
输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7   
```

注意: 合并必须从两个树的根节点开始。

### 题解

#### 算法1 O(n)

本质还是对二叉树的遍历，使用深度优先遍历方式。时间复杂度O(n)。

```$java
public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
        return root2;
    }
    if (root2 == null) {
        return root1;
    }
    TreeNode merged = new TreeNode(root1.val + root2.val);
    merged.left = mergeTrees(root1.left, root2.left);
    merged.right = mergeTrees(root1.right, root2.right);
    return merged;
}
```

