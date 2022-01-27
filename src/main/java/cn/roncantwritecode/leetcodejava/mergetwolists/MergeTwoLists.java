package cn.roncantwritecode.leetcodejava.mergetwolists;

import cn.roncantwritecode.leetcodejava.utils.ListNode;
import cn.roncantwritecode.leetcodejava.utils.ListNodeOperation;

/**
 * @author Ron Wu
 * @date 2020/3/25
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        int[] arrays1 = {2, 4, 3};
        ListNode l1 = ListNodeOperation.convertToSingleListNode(arrays1);
        int[] arrays2 = {5, 6, 4};
        ListNode l2 = ListNodeOperation.convertToSingleListNode(arrays2);

        ListNode result = mergeTwoLists.mergeTwoLists(l1, l2);

        ListNodeOperation.show(result);

    }

    /**
     * 依次循环 O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // 其中一个链表为空，另一个链表直接加入尾部
        if (l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }

        return result.next;
    }
}
