package cn.roncantwritecode.leetcodejava.reverselist;

import cn.roncantwritecode.leetcodejava.utils.ListNode;
import cn.roncantwritecode.leetcodejava.utils.ListNodeOperation;

/**
 * @author Ron Wu
 * @date 2020/4/9
 */
public class ReverseList {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        int[] arrays = {1, 2, 3, 4, 5};
        ListNode head = ListNodeOperation.convertToSingleListNode(arrays);

        ListNode result = reverseList.reverseList(head);

        ListNodeOperation.show(result);

        head = ListNodeOperation.convertToSingleListNode(arrays);

        result = reverseList.reverseListReCurrent(head);

        ListNodeOperation.show(result);
    }

    /**
     * 迭代 O(n)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            // 记录下个循环节点
            ListNode temp = head.next;
            // 将当前节点插入到result的头部
            head.next = result;
            result = head;
            // 重置下个循环节点
            head = temp;
        }

        return result;
    }

    /**
     * 递归 O(n)
     * @param head
     * @return
     */
    public ListNode reverseListReCurrent(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归到最后再逐一反转处理
        ListNode result = reverseListReCurrent(head.next);
        // 即head.next节点的下个节点指向next，目前顺序为 head-》head.next-》head
        head.next.next = head;
        // 断开head 剩下head.next-》head
        head.next = null;

        return result;
    }
}
