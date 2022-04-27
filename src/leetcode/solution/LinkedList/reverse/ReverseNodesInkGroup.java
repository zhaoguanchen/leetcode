package leetcode.solution.LinkedList.reverse;

import leetcode.structure.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 */
public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        ListNode list1 = ListNode.constructList(array1);
        int k = 2;
        ReverseNodesInkGroup reverseNodesInkGroup = new ReverseNodesInkGroup();
        ListNode ans = reverseNodesInkGroup.reverseKGroup(list1, k);
        ListNode.print(ans);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode b = head;

        for (int i = 0; i < k; i++) {
            // 不足k个，直接返回
            if (b == null) {
                return head;
            }
            b = b.next;

        }
        // reverse this group, b is not involved.
        ListNode newHead = reverseBetween(head, b);
        // head became the last node in current group. so make head point to next group.
        head.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * reverse Linked List between head and last(last is not involved).
     *
     * @param head
     * @param last
     * @return
     */
    private ListNode reverseBetween(ListNode head, ListNode last) {
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode cur = head.next;

        while (cur != last) {
            head.next = cur.next;
            cur.next = vHead.next;
            vHead.next = cur;
            cur = head.next;
        }

        return vHead.next;
    }


}
