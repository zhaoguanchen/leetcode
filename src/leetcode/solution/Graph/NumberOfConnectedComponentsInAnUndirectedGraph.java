package leetcode.solution.Graph;

/**
 * 323. Number of Connected Components in an Undirected Graph
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {0, 1}, {3, 4}};
        int n = 5;
        NumberOfConnectedComponentsInAnUndirectedGraph i = new NumberOfConnectedComponentsInAnUndirectedGraph();
        System.out.println(i.countComponents(n, graph));
    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);

        // 联通节点
        for (int[] item : edges) {
            uf.connect(item[0], item[1]);
        }

        return uf.getCount();
    }
}

class UF {
    /**
     * 下标i父节点对应的父节点坐标
     */
    private int[] father;
    /**
     * 联通分量的个数
     */
    private int count;


    UF(int n) {
        father = new int[n];
        // 初始化联通分量为n
        count = n;
        for (int i = 0; i < n; i++) {
            // 每个点都是根节点，其父节点指向自己
            father[i] = i;
        }
    }

    public int getCount() {
        return count;
    }


    /**
     * 联通两个节点
     *
     * @param p
     * @param q
     */
    public void connect(int p, int q) {
        int fatherOfP = findFather(p);
        int fatherOfQ = findFather(q);
        // 同一最大父节点，则二者已经联通，无需操作
        if (fatherOfP == fatherOfQ) {
            return;
        }
        // 联通两个根节点，变成一棵树
        father[fatherOfQ] = fatherOfP;
        // 联通分量减一
        count--;
    }

    /**
     * 判断两点是否联通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        int rootP = findFather(p);
        int rootQ = findFather(q);
        return rootP == rootQ;
    }


    private int findFather(int s) {
        while (father[s] != s) {
            // 寻找根节点，并进行路径压缩（父节点指向爷爷节点）
            father[s] = father[father[s]];
            s = father[s];
        }
        return s;
    }


}