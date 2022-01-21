package cn.roncantwritecode.leetcodejava.diameterofbinarytree;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

/**
 * @author Ron Wu
 * @date 2020/3/25
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        int result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(result);
    }

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
}
