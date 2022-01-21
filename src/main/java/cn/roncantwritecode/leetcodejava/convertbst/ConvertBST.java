package cn.roncantwritecode.leetcodejava.convertbst;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

/**
 * @author Ron Wu
 * @date 2020/4/21
 */
public class ConvertBST {

    public static void main(String[] args) {
        ConvertBST convertBST = new ConvertBST();
        Integer[] nums = {5, 3, 7, 2, 4, 6, 8};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        TreeNode result = convertBST.convertBST(root);
        TreeOperation.show(result);
    }

    /**
     * 递归 O(n)
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        convertWithNumber(root, 0);
        return root;
    }

    public int convertWithNumber(TreeNode root, int n) {
        if (root == null) {
            return n;
        }
        // 右中左的中序遍历
        int rightValue = convertWithNumber(root.right, n);
        root.val += rightValue;
        int leftValue = convertWithNumber(root.left, root.val);
        // 最后一个遍历的左子节点的值，返回给下一层
        return leftValue;
    }
}
