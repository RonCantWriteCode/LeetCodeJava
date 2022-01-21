package cn.roncantwritecode.leetcodejava.mergetwolists;

import cn.roncantwritecode.leetcodejava.utils.ListNode;

/**
 * @author Ron Wu
 * @date 2020/3/25
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists.mergeTwoLists(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

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
