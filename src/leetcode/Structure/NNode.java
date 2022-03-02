package leetcode.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a list node.
 */
public class NNode {
    public int val;
    public List<NNode> children;


    public NNode() {
        children = new ArrayList<NNode>();
    }

    public NNode(int _val) {
        val = _val;
        children = new ArrayList<NNode>();
    }

    public NNode(int _val, ArrayList<NNode> _children) {
        val = _val;
        children = _children;
    }

    /**
     * generate by array
     *
     * @param array
     * @return
     */
    public static NNode constructTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        NNode root = new NNode(array[0]), midNode = root;
        List<NNode> nodeList = new ArrayList<>();
        int listIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) {
                if (listIndex + 1 < nodeList.size()) {
                    midNode = nodeList.get(listIndex);
                    listIndex++;
                } else {
                    nodeList.clear();
                }
                continue;
            }
            if (midNode.children == null) {
                midNode.children = new ArrayList<>();
            }
            NNode node = new NNode(array[i]);
            nodeList.add(node);
            midNode.children.add(node);
        }
        return root;
    }


}
