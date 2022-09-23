package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        ListNode root = ListNode.constructList(array);
        int n = 2;
        ListNode.print(removeNthFromEnd(root, n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 因为n可能等于链表长度（可能删除头节点），需要虚拟头节点
        ListNode vHead = new ListNode(-1);
        vHead.next = head;

        ListNode fast = vHead;
        ListNode slow = vHead;
        // 快指针先走n+1步（多走一步是为了让慢指针指向待删除节点的前一节点）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // 慢指针与快指针同步前进，当快指针到达链表结尾时，
        // 慢指针到达倒数第n+1个节点，为待删除节点的前一节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除对应节点
        slow.next = slow.next.next;
        return vHead.next;
    }

}
