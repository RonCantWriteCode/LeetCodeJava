package cn.roncantwritecode.leetcodejava.mergetrees;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

/**
 * @author Ron Wu
 * @date 2022/1/21
 */
public class MergeTrees {

    public static void main(String[] args) {
        MergeTrees mergeTrees = new MergeTrees();
        Integer[] nums = {1, 3, 2, 5};
        TreeNode root1 = ConstructTree.constructTree(nums);
        TreeOperation.show(root1);
        Integer[] nums2 = {2, 1, 3, null, 4, null, 7};
        TreeNode root2 = ConstructTree.constructTree(nums2);
        TreeOperation.show(root2);
        TreeNode result = mergeTrees.mergeTrees(root1, root2);
        TreeOperation.show(result);
    }

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
}
