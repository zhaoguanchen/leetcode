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
        // 虚拟节点
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        // 慢指针，指向最新确定的小于x的节点
        ListNode p1 = vHead;
        // 快指针，寻找未知区间内小于x的节点；由于要操作节点，p2指向目标节点的前一节点（通过p2.next判断）
        ListNode p2;

        // 如果链表前部节点小于x,则p1后移；
        while (p1.next != null && p1.next.val < x) {
            p1 = p1.next;
        }

        // p1.next为下一个大于等于x的数，
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
