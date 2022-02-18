### 题目描述
206.反转链表

反转一个单链表。

示例：
```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

进阶：

你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

### 题解

#### 算法1 迭代 O(n)

循环每个节点，将节点插入到结果列表的头部。时间复杂度O(n)


```$java
/**
 * 迭代 O(n)
 * @param head
 * @return
 */
public ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode result = null;
    while (current != null) {
        // 记录下个循环节点
        ListNode temp = current.next;
        // 将当前节点插入到result的头部
        current.next = result;
        result = current;
        // 重置下个循环节点
        current = temp;
    }

    return result;
}
```

#### 算法2 递归 O(n)

参考官方题解递归处理，从尾部开始，每次调换顺序。即每次建环再断开环，这样可以将节点加到结果列表的尾部。时间复杂度O(n)

例如 (1, 2, 3, 4, 5)

递归处理:
- 第5次，返回result = (5)
- 第4次，head=(4,5) result=(5),链接上head，head=(4,5,4...) result=(5,4,5,4....)，设置4的next为空 head=(4) result=(5,4)
- 第3次，head=(3,4) result=(5,4),链接上head，head=(3,4,3...) result=(5,4,3,4,3....)，设置3的next为空 head=(3) result=(5,4,3)
- 第2次，head=(2,3) result=(5,4,3),链接上head，head=(2,3,2...) result=(5,4,3,2,3....)，设置2的next为空 head=(2) result=(5,4,3,2)
- 第1次，head=(1,2) result=(5,4,3,2),链接上head，head=(1,2,12...) result=(5,4,3,2,1,2....)，设置1的next为空 head=(1) result=(5,4,3,2,1)

```$java
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
    // 即head.next节点的下个节点指向next，目前顺序为 head-》head.next-》head...
    head.next.next = head;
    // 断开head 剩下head.next-》head
    head.next = null;

    return result;
}
```
