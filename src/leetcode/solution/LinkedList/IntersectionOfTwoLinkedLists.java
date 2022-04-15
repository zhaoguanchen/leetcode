package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        ListNode root = ListNode.constructList(array);
        Integer[] array1 = {2, 3};
        ListNode root1 = ListNode.constructList(array1);

        ListNode p1 = root1;
        ListNode p2 = root;
        for (int i = 0; i < 1; i++) {
            p1 = p1.next;
        }
        for (int i = 0; i < 2; i++) {
            p2 = p2.next;
        }
        p1.next = p2;

        ListNode.print(getIntersectionNode(root, root1));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        // p1 和 p2都走 headA + headB的长度，若有交点，则第二段必定相遇
        while (p1 != p2) {
            // 走到头再走headB
            // 为什么不能是p1.next==null?
            // 若条件为p1.next==null，则永远不会走到null。若无交点，则永远不会出现p1==p2,此时陷入死循环。
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // 走到头再走headA
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }

        }

        // p1要么为交点，要么为null(无交点)
        return p1;
    }
}
