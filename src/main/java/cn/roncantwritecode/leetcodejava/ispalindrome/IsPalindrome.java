package cn.roncantwritecode.leetcodejava.ispalindrome;

import cn.roncantwritecode.leetcodejava.utils.ListNode;
import cn.roncantwritecode.leetcodejava.utils.ListNodeOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ron Wu
 * @date 2020/4/20
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        int[] arrays = {1, 2, 2, 1};
        ListNode head = ListNodeOperation.convertToSingleListNode(arrays);

        boolean result = isPalindrome.isPalindrome(head);
        System.out.println(result);
        result = isPalindrome.isPalindromeReverse(head);
        System.out.println(result);

    }


    /**
     * 双指针 O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> temp = new ArrayList<>();

        // 复制到数组中
        ListNode curr = head;
        while (curr != null) {
            temp.add(curr.val);
            curr = curr.next;
        }

        int headInd = 0;
        int tailInd = temp.size() - 1;
        while (headInd < tailInd) {
            // 前后比对
            if (!temp.get(headInd).equals(temp.get(tailInd))) {
                return false;
            }
            headInd++;
            tailInd--;
        }

        return true;
    }

    /**
     * 快慢指针 O(n)
     * @param head
     * @return
     */
    public boolean isPalindromeReverse(ListNode head) {
        boolean result = true;
        if (head == null) {
            return result;
        }

        // 快慢指针得到链表一半
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分链表
        ListNode half = reverseList(slow.next);

        ListNode p1 = head;
        ListNode p2 = half;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        slow.next = reverseList(half);

        return result;
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
}
