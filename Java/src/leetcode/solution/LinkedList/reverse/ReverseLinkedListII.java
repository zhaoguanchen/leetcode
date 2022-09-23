package leetcode.solution.LinkedList.reverse;

import leetcode.structure.ListNode;

/**
 * 92. Reverse Linked List II
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        ListNode list1 = ListNode.constructList(array1);
        int left = 2;
        int right = 4;
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode ans = reverseLinkedListII.reverseBetweenIteration(list1, left, right);
        ListNode.print(ans);
    }


    public ListNode reverseBetweenIteration(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode vHead = new ListNode(-1); // create a dummy node to mark the head of this list
        vHead.next = head;
        ListNode root = vHead;

        // root is the node before left
        for (int i = 1; i < left; i++) {
            root = root.next;
        }

        // firstNode is the first node before swap. It will not be changed.
        ListNode firstNode = root.next;
        // cur is the node to be swapped.
        ListNode cur = root.next.next;

        // except cur, the count of node that need to move
        int count = right - left;
        for (int i = 0; i < count; i++) {
            firstNode.next = cur.next;
            cur.next = root.next;
            root.next = cur;
            cur = firstNode.next;
        }

        return vHead.next;
    }

}
