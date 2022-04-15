package leetcode.solution.LinkedList;

import leetcode.structure.ListNode;

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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 指针相遇
            if (fast == slow) {
                break;
            }

        }
        // 非指针相遇，而是走到了尽头
        if (fast == null || fast.next == null) {
            return false;
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
