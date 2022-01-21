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
        TreeNode result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        TreeOperation.show(result);
    }

    /**
     *
     * @return
     */
    public TreeNode diameterOfBinaryTree(TreeNode root) {
        

        return null;
    }
}
