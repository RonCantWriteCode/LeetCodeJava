package cn.roncantwritecode.leetcodejava.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ron Wu
 * @date 2022/1/27
 */
public class ListNodeOperation {

    /**
     * 控制台输出ListNode
     * @param root
     */
    public static void show(ListNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
            return;
        }
        if (hasCycle(root)) {
            System.out.println("Exist Cycle!");
            return;
        }

        StringBuffer output = new StringBuffer("[");
        while (root != null) {
            output.append(root.val);
            output.append(",");
            root = root.next;
        }
        if (output.charAt(output.length() -1) == ',') {
            output.deleteCharAt(output.length() -1);
        }
        output.append("]");
        System.out.println(output.toString());
    }

    /**
     * 是否存在环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 将int数组转化成ListNode
     * @param arrays
     * @return
     */
    public static ListNode convertToSingleListNode(int[] arrays) {
        if (arrays.length < 1) {
            return null;
        }
        ListNode newHead = new ListNode(0) ;
        ListNode pre = newHead;
        for (int i=0; i < arrays.length; i++) {
            ListNode listNode = new ListNode(arrays[i]);
            pre.next = listNode;
            pre = listNode;
        }

        return newHead.next;
    }

    public static ListNode getListNodeByIndex(ListNode root, int index) {
        ListNode listNode = null;
        if (index < 1 || root == null) {
            return null;
        }

        for (int i=1; i <= index; i++) {
            listNode = root.next;
        }

        return listNode;
    }
}
