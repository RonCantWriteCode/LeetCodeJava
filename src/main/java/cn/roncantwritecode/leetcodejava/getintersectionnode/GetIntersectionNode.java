package cn.roncantwritecode.leetcodejava.getintersectionnode;

import cn.roncantwritecode.leetcodejava.utils.ListNode;

/**
 * @author wurunlong
 * @date 2020/4/7
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(3);

        ListNode result = getIntersectionNode.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println(0);
        }
    }

    /**
     * 双指针 O(n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
