package cn.roncantwritecode.leetcodejava.pathsum;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

/**
 * @author wurunlong
 * @date 2020/4/20
 */
public class PathSum {

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        Integer[] nums = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        int sum = 8;
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        int result = pathSum.pathSum(root, sum);
        System.out.println(result);
    }

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

        // array保存根节点到当前节点的路径，depth保存当前节点的深度
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
}
