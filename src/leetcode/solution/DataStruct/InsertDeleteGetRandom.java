package leetcode.solution.DataStruct;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 */
public class InsertDeleteGetRandom {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        int ans = randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.

        System.out.println(ans);
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        ans = randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.  }
        System.out.println(ans);

    }
}

/**
 * @Description: HashMap + ArrayList
 * @Author: Guanchen Zhao
 * @Date: 2022/5/12
 */
class RandomizedSet {

    /**
     * val and its index
     */
    Map<Integer, Integer> map;

    /**
     * elements
     */
    List<Integer> list;

    Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;

    }

    /**
     * overwrite the val to be removed with the last val.
     * then remove the last val.
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int indexToRemove = map.get(val);
        int indexOfLast = list.size() - 1;
        int lastVal = list.get(indexOfLast);
        list.set(indexToRemove, lastVal);
        map.put(lastVal, indexToRemove);
        map.remove(val);
        list.remove(indexOfLast);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
