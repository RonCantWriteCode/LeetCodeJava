package cn.roncantwritecode.leetcodejava.inordertraversal;

import cn.roncantwritecode.leetcodejava.utils.ConstructTree;
import cn.roncantwritecode.leetcodejava.utils.TreeNode;
import cn.roncantwritecode.leetcodejava.utils.TreeOperation;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ron Wu
 * @date 2022/2/9
 */
public class InorderTraversal {
    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        Integer[] nums = {1, null, 2};
        TreeNode root = ConstructTree.constructTree(nums);
        TreeOperation.show(root);
        List<Integer> result = inorderTraversal.inorderTraversal(root);
        System.out.println(result);
        result = inorderTraversal.inorderTraversalIterator(root);
        System.out.println(result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public List<Integer> inorderTraversalIterator(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 遍历所有左节点，并将根存入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
