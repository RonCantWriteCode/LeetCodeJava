package cn.roncantwritecode.leetcodejava.addtwonumbers;

import cn.roncantwritecode.leetcodejava.utils.ListNode;
import cn.roncantwritecode.leetcodejava.utils.ListNodeOperation;

/**
 * @author Ron Wu
 * @date 2020/3/23
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] arrays1 = {2, 4, 3};
        ListNode l1 = ListNodeOperation.convertToSingleListNode(arrays1);
        int[] arrays2 = {5, 6, 4};
        ListNode l2 = ListNodeOperation.convertToSingleListNode(arrays2);

        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        ListNodeOperation.show(result);
    }

    /**
     * 依次循环相加 O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个-1的头结点，后面不用循环每次判断需要创建第一个节点
        ListNode result = new ListNode(-1);
        ListNode cur = result;

        // 进位
        int index = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + index;
            // 取整
            index = sum / 10;
            // 取余
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 最后计算大于10，需要补一位
        if (index > 0) {
            cur.next = new ListNode(1);
        }

        return result.next;
    }
}
