package cn.roncantwritecode.leetcodejava.utils;

/**
 * @author Ron Wu
 * @date 2022/1/27
 */
public class ListNodeOperation {

    /**
     * 控制台输出ListNode
     * @param root
     */
    public static void show(ListNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
            return;
        }

        StringBuffer output = new StringBuffer("[");
        while (root != null) {
            output.append(root.val);
            output.append(",");
            root = root.next;
        }
        if (output.charAt(output.length() -1) == ',') {
            output.deleteCharAt(output.length() -1);
        }
        output.append("]");
        System.out.println(output.toString());
    }

    /**
     * 将int数组转化成ListNode
     * @param arrays
     * @return
     */
    public static ListNode convertToListNode(int[] arrays) {
        if (arrays.length < 1) {
            return null;
        }
        ListNode newHead = new ListNode(0) ;
        ListNode pre = newHead;
        for (int i=0; i < arrays.length; i++) {
            ListNode listNode = new ListNode(arrays[i]);
            pre.next = listNode;
            pre = listNode;
        }

        return newHead.next;
    }
}
