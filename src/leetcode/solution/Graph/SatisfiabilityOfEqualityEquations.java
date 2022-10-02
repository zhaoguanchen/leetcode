package leetcode.solution.Graph;

/**
 * 990. Satisfiability of Equality Equations
 */
public class SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=a"};
        SatisfiabilityOfEqualityEquations i = new SatisfiabilityOfEqualityEquations();
        System.out.println(i.equationsPossible(equations));
    }

    public boolean equationsPossible(String[] equations) {
        // 26个字母
        SatisfiabilityOfEqualityEquationsUF uf = new SatisfiabilityOfEqualityEquationsUF(26);

        // 要通过 -'a'获得相对下标
        for (String item : equations) {
            // 判断等于情况,联通两个相等的字符
            if ('=' == item.charAt(1)) {
                uf.connect(item.charAt(0) - 'a', item.charAt(3) - 'a');
            }
        }

        // 检查不等于节点是否联通，联通则不满足
        for (String item : equations) {
            // 判断不等于情况
            if ('!' == item.charAt(1)) {
                if (uf.isConnected(item.charAt(0) - 'a', item.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }


}


class SatisfiabilityOfEqualityEquationsUF {
    /**
     * 下标i父节点对应的父节点坐标
     */
    private int[] father;
    /**
     * 联通分量的个数
     */
    private int count;


    SatisfiabilityOfEqualityEquationsUF(int n) {
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