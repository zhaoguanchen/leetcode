package leetcode.solution.List;

import leetcode.Structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        ListNode root = ListNode.constructList(array);
        ListNode.setCycle(root, 4);

        System.out.println(hasCycle(root));
        System.out.println(hasCycle1(root));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pre = head;
        ListNode pro = head.next;

        while (pre != pro) {
            if (pro == null || pro.next == null) {
                return false;
            }

            pre = pre.next;
            pro = pro.next.next;
        }

        return true;

    }

    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;

        }

        return false;

    }
}
