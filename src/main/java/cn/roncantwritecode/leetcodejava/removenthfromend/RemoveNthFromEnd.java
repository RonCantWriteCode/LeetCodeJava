package cn.roncantwritecode.leetcodejava.removenthfromend;

import cn.roncantwritecode.leetcodejava.utils.ListNode;
import cn.roncantwritecode.leetcodejava.utils.ListNodeOperation;

/**
 * @author Ron Wu
 * @date 2022/1/27
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        int[] arrays = {1, 2, 3, 4, 5};
        ListNode head = ListNodeOperation.convertToSingleListNode(arrays);
        int n = 2;
        ListNode result = removeNthFromEnd.removeNthFromEnd(head, n);
        ListNodeOperation.show(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 获取长度
        int length = 0;
        ListNode listNode = head;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }

        // 定义一个新的头结点，方便记录要返回的位置
        ListNode newHead = new ListNode(-1, head);
        listNode = newHead;
        // 获取要移除的前一个节点
        for (int i = 0; i < length - n; i++) {
            listNode = listNode.next;
        }
        // 移除节点
        listNode.next = listNode.next.next;

        return newHead.next;
    }
}
