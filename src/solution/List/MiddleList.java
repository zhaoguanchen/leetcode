package solution.List;

import Structure.ListNode;

/**
 * 876. Middle of the Linked List
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleList {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        ListNode root = ListNode.constructList(array);
        System.out.println(middleNode(root).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode pro = head;
        ListNode pre = head;

        while (pro != null && pro.next != null) {
            pro = pro.next.next;
            pre = pre.next;
        }
        return pre;
    }


}
