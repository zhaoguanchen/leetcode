package Structure;

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


}
