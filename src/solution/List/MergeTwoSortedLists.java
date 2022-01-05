package solution.List;

import Structure.ListNode;

/**
 * 141. Linked List Cycle
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        Integer[] array2 = {1, 3, 4};
        ListNode list1 = ListNode.constructList(array1);
        ListNode list2 = ListNode.constructList(array2);

        ListNode.print(mergeTwoLists(list1, list2));
//        ListNode.print(mergeTwoLists1(list1, list2));

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode();
        ListNode cur = res;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }

            cur = cur.next;
        }

        if (p1 == null) {
            cur.next = p2;

        } else {
            cur.next = p1;
        }
        return res.next;
    }


    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode();
        ListNode cur = res;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                cur.next = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                cur.next = p1;
                p1 = p1.next;

            } else {

                if (p1.val < p2.val) {
                    cur.next = p1;
                    p1 = p1.next;
                } else {
                    cur.next = p2;
                    p2 = p2.next;
                }

            }

            cur = cur.next;
        }

        return res.next;

    }
}
