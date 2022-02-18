### 题目描述
2.两数相加

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。


示例：
```
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```

### 题解

#### 算法1 依次相加
依次循环相加，需要添加进位。时间复杂度O(n)

注意：
1. 定义一个-1的头结点，后面不用循环每次判断需要创建第一个节点
2. 如果最后有进位需要补1

```$java
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
```