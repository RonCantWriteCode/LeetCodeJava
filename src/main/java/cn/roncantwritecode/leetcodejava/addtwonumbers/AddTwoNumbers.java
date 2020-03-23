package cn.roncantwritecode.leetcodejava.addtwonumbers;

/**
 * @author wurunlong
 * @date 2020/3/23
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers twoSum = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = twoSum.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

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
