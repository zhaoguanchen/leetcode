package leetcode.solution.LinkedList.reverse;

import leetcode.structure.ListNode;

/**
 * 61. Rotate List
 */
public class RotateList {

    public static void main(String[] args) {
        Integer[] array = {0, 1, 2};
        ListNode l1 = ListNode.constructList(array);
        int k = 4;
        RotateList rotateList = new RotateList();
        ListNode ans = rotateList.rotateRight(l1, k);
        ListNode.print(ans);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        k = k % length;
        // 无需处理
        if (k == 0) {
            return head;
        }
        // 找到要断开的前一节点
        cur = head;
        for (int i = 0; i < length - k - 1; i++) {
            cur = cur.next;
        }

        // 新节点指针
        ListNode vHead = cur.next;
        // 设为null
        cur.next = null;

        // 寻找尾节点，链接到头节点
        cur = vHead;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = head;
        return vHead;
    }
}
