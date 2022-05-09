package leetcode.solution.DataStruct;

import java.util.*;

/**
 * 341. Flatten Nested List Iterator
 */
public class FlattenNestedListIterator {

    public static void main(String[] args) {
        NestedInteger n1 = new NestedInteger(true, 1, null);
        NestedInteger n2 = new NestedInteger(true, 1, null);
        List<NestedInteger> nestedList1 = new ArrayList<>();
        nestedList1.add(n1);
        nestedList1.add(n2);

        NestedInteger o1 = new NestedInteger(false, null, nestedList1);

        NestedInteger n3 = new NestedInteger(true, 1, null);
        NestedInteger n4 = new NestedInteger(true, 1, null);
        List<NestedInteger> nestedList2 = new ArrayList<>();
        nestedList2.add(n3);
        nestedList2.add(n4);
        NestedInteger o2 = new NestedInteger(false, null, nestedList2);

        NestedInteger i1 = new NestedInteger(true, 2, null);


        List<NestedInteger> finalObject = new ArrayList<>();
        finalObject.add(o1);
        finalObject.add(i1);
        finalObject.add(o2);
        NestedIterator solution = new NestedIterator(finalObject);
        Integer[] f = new Integer[10];

        int i = 0;
        while (solution.hasNext()) {
            f[i++] = solution.next();
        }
        System.out.println(Arrays.toString(f));
    }


}

/**
 * @Description: Using LinkedList. Same as Deque.
 * <p>
 * Using Stack is also OK.
 * @Author: Guanchen Zhao
 * @Date: 2022/5/9
 */
class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> list;

    /**
     * convert to LinkedList
     *
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    /**
     * pop the first element directly.
     *
     * @return next Integer
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        NestedInteger first = list.removeFirst();
        return first.getInteger();
    }

    /**
     * check and parse
     * <p>
     * make the first element is Integer.
     *
     * @return hasNext
     */
    @Override
    public boolean hasNext() {
        // `while` is needed because empty sub list exist.
        while (!list.isEmpty()) {
            if (list.getFirst().isInteger()) {
                return true;
            }
            NestedInteger first = list.removeFirst();
            List<NestedInteger> subList = first.getList();
            // remember add elements in reverse order.
            for (int i = subList.size() - 1; i >= 0; i--) {
                list.addFirst(subList.get(i));
            }
        }

        return false;
    }
}


/**
 * @Description: NestedInteger. The data struct definition
 * @Author: Guanchen Zhao
 * @Date: 2022/5/9
 */
class NestedInteger {
    private Integer number;

    private List<NestedInteger> list;

    private boolean isInteger;

    NestedInteger(boolean isInteger, Integer number, List<NestedInteger> list) {
        this.isInteger = isInteger;
        if (isInteger) {
            this.number = number;
        } else {
            this.list = list;
        }
    }


    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInteger;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return number;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }
}

