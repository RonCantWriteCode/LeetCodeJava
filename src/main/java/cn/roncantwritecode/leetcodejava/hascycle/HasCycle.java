package cn.roncantwritecode.leetcodejava.hascycle;

import cn.roncantwritecode.leetcodejava.utils.ListNode;
import cn.roncantwritecode.leetcodejava.utils.ListNodeOperation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ron Wu
 * @date 2020/4/2
 */
public class HasCycle {
    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();

        /*ListNode head = new ListNode(3);
        ListNode l2 = new ListNode(2);
        head.next = l2;
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = l2;*/

        int[] arrays = {3, 2, 0, -4};
        ListNode head = ListNodeOperation.convertToSingleListNode(arrays);
        ListNodeOperation.getListNodeByIndex(head, 3).next = ListNodeOperation.getListNodeByIndex(head, 1);

        boolean result = hasCycle.hasCycle(head);
        System.out.println(result);
        result = hasCycle.hasCyclePoint(head);
        System.out.println(result);

    }

    /**
     * 遍历放到Set中 O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
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
     * 双指针 O(n)
     * @param head
     * @return
     */
    public boolean hasCyclePoint(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1 != l2) {
            if (l2 == null || l2.next == null) {
                return false;
            }
            l1 = l1.next;
            // 一次两个节点
            l2 = l2.next.next;
        }

        return true;
    }

}
