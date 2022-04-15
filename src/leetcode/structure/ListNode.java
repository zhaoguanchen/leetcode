package leetcode.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a list node.
 */
public class ListNode {

    public int val;

    public ListNode next;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    /**
     * generate by array
     *
     * @param array
     * @return
     */
    public static ListNode constructList(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        int length = array.length;
        ListNode root = new ListNode(array[0]);

        ListNode currentNode = root;
        ListNode newNode;
        for (int i = 1; i < length; i++) {
            newNode = new ListNode(array[i]);
            currentNode.next = newNode;
            currentNode = currentNode.next;
        }
        return root;
    }

    public static void setCycle(ListNode head, Integer m) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode last = head;

        while (last.next != null) {
            last = last.next;
        }
        ListNode root = head;

        for (int i = 0; i < m; i++) {
            if (root == null) {
                return;
            }
            root = root.next;
        }
        last.next = root;
    }

    /**
     * generate by array
     *
     * @param
     * @return
     */
    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println("node is null");
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.add(listNode.val);
        while (listNode.next != null) {

            list.add(listNode.next.val);
            listNode = listNode.next;
        }

        System.out.println(Collections.singletonList(list));
    }
}
