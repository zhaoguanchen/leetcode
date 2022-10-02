package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 133. Clone Graph
 */
public class CloneGraph {

    public static void main(String[] args) {

    }


}


class CloneGraphSolution {

    HashMap<Integer, Node> memo;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        this.memo = new HashMap<>();
        Node nNode = new Node(node.val);
        memo.put(nNode.val, nNode);
        dfs(node, nNode);

        return nNode;
    }

    private void dfs(Node originNode, Node node) {
        List<Node> nodeList = originNode.neighbors;
        List<Node> newList = new ArrayList<>();
        for (Node oNode : nodeList) {
            int val = oNode.val;
            if (memo.containsKey(val)) {
                newList.add(memo.get(val));
            } else {
                Node newNode = new Node(val);
                memo.put(val, newNode);
                newList.add(newNode);
                dfs(oNode, newNode);
            }
        }

        node.neighbors = newList;
    }

}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}