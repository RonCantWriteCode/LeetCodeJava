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
        for () {
        }

        return head;
    }
}
