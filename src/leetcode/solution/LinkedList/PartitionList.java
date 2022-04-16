package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 86. Partition List
 */
public class PartitionList {

    public static void main(String[] args) {
        Integer[] array = {1, 4, 3, 2, 5, 2};
        ListNode l1 = ListNode.constructList(array);
        int x = 3;
        PartitionList partitionList = new PartitionList();
        ListNode ans = partitionList.partition(l1, x);
        ListNode.print(ans);
    }

    public ListNode partition(ListNode head, int x) {

        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode p1 = vHead;
        ListNode p2;

        while (p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }

        p2 = p1.next;

        while (p2 != null && p2.next != null) {
            // 找值小于x的节点
            if (p2.next.val < x) {
                ListNode p1Next = p1.next;
                ListNode target = p2.next;
                p2.next = p2.next.next;
                p1.next = target;
                target.next = p1Next;
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }

        }

        return vHead.next;
    }

}
