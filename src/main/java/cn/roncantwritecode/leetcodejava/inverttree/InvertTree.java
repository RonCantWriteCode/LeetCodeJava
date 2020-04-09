package cn.roncantwritecode.leetcodejava.inverttree;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

/**
 * @author wurunlong
 * @date 2020/4/9
 */
public class InvertTree {

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        TreeNode result = invertTree.invertTree(root);
        TreeOperation.show(result);
    }


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
}
