### 题目描述
21.合并两个有序链表

将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

### 题解

#### 算法1 依次比较 O(n)
依次循环比较。时间复杂度O(n)

注意：
1. 定义一个-1的头结点，后面不用循环每次判断需要创建第一个节点


```$java
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
```
