package cn.roncantwritecode.leetcodejava.maxdepth;

/**
 * @author wurunlong
 * @date 2020/4/1
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);
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
