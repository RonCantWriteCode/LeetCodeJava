### 题目描述
141.环形链表

给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

 

示例 1：
```
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
```
![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/hasCycle/circularlinkedlist.png)

示例 2：
```
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
```
![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/hasCycle/circularlinkedlist_test2.png)

示例 3：
```
输入：head = [1], pos = -1
输出：false
解释：链表中没有环
```
![](https://github.com/RonCantWriteCode/LeetCodeJava/blob/master/src/main/resources/hasCycle/circularlinkedlist_test3.png)

进阶：

你能用 O(1)（即，常量）内存解决此问题吗？

### 题解

#### 算法1 哈希 O(n)

使用哈希set，区分之前是否已经扫描过。不使用数值判重而使用整个对象。时间复杂度O(n)

```$java
/**
 * 遍历放到Set中 O(n)
 * @param head
 * @return
 */
public boolean hasCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    while (head != null) {
        if (set.contains(head)) {
            return true;
        } else {
            set.add(head);
        }
        head = head.next;
    }
    return false;
}
```

#### 算法2 双指针 O(n)


使用双指针遍历，其中一个按个遍历，另一个每次跳过一个遍历，速度不一致，当快指针可以追上慢指针时，说明有环，空间复杂度满足进阶中的O(1)。时间复杂度O(n)

```$java
/**
 * 双指针 O(n)
 * @param head
 * @return
 */
public boolean hasCyclePoint(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode l1 = head;
    ListNode l2 = head.next;
    while (l1 != l2) {
        if (l2 == null || l2.next == null) {
            return false;
        }
        l1 = l1.next;
        // 一次两个节点
        l2 = l2.next.next;
    }

    return true;
}
```