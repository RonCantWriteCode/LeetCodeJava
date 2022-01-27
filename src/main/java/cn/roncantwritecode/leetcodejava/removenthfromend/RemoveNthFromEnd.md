### 题目描述
19. 删除链表的倒数第 N 个结点

给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

示例1:

![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/removeNthFromEnd/remove_ex1.jpg)

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
```

示例2:
```
输入：head = [1], n = 1
输出：[]
```

示例3:
```
输入：head = [1,2], n = 1
输出：[1]
```

提示：

* 链表中结点的数目为 sz
* 1 <= sz <= 30
* 0 <= Node.val <= 100
* 1 <= n <= sz


进阶：你能尝试使用一趟扫描实现吗？



### 题解

#### 算法1 O(n)

获取链表的长度，根据长度和n去删除节点。时间复杂度O(n)。

```$java
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
```
