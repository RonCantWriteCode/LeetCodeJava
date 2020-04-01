package cn.roncantwritecode.leetcodejava.issymmetric;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.Stack;

/**
 * @author wurunlong
 * @date 2020/4/1
 */
public class IsSymmetric {

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean result = isSymmetric.isSymmetric(root);
        System.out.println(result);
        result = isSymmetric.isSymmetricStack(root);
        System.out.println(result);
    }

    /**
     * 递归 O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        // 左节点等于镜像的右节点
        if (!isMirror(t1.left, t2.right)) {
            return false;
        }
        // 右节点等于镜像的左节点
        if (!isMirror(t1.right, t2.left)) {
            return false;
        }
        return true;
    }

    /**
     * 迭代 O(n)
     * @param root
     * @return
     */
    public boolean isSymmetricStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return true;
        }
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();

            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            // 左节点等于镜像的右节点
            stack.push(t1.left);
            stack.push(t2.right);
            // 右节点等于镜像的左节点
            stack.push(t1.right);
            stack.push(t2.left);
        }

        return true;
    }
}
