### 题目描述
234.回文链表

请判断一个链表是否为回文链表。

示例 1:
```
输入: 1->2
输出: false
```

示例 2:
```
输入: 1->2->2->1
输出: true
```

进阶：

你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

### 题解

#### 算法1 双指针 O(n)

双指针判断是否回文，需将链表复制到数组列表中。时间复杂度O(n)，空间复杂度O(n)。

```$java
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
```

#### 算法2 快慢指针 O(n)

参考官方题解

- 使用快慢指针，当快指针结束时，慢指针刚好到链表的一半
- 慢指针反转后半部分链表
- 比较前后部分链表判断是否回文
- 再反转一次后半部分链表恢复链表

时间复杂度O(n)，空间复杂度O(n)


```$java
/**
 * 快慢指针 O(n)
 * @param head
 * @return
 */
public boolean isPalindromeReverse(ListNode head) {
    boolean result = true;
    if (head == null) {
        return false;
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
```
