package cn.roncantwritecode.leetcodejava.maxdepth;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

/**
 * @author Ron Wu
 * @date 2020/4/1
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        Integer[] nums = {3, 9, 20, 15, 17};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        int result = maxDepth.maxDepth(root);
        System.out.println(result);
    }

    /**
     * 递归 O(n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
}
