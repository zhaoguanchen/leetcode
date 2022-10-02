package leetcode.solution.DataStruct;

import java.util.*;

/**
 * 460. LFU Cache
 */
public class LFUCache {

    private Map<Integer, Integer> keyToValMap;

    private Map<Integer, Integer> keyToFreqMap;

    private Map<Integer, LinkedHashSet<Integer>> freqToKeySet;

    private int minFreq;

    private int cap;


    public void print() {
        System.out.println(minFreq);
        System.out.println(freqToKeySet);
        System.out.println(keyToValMap);
        System.out.println(keyToFreqMap);
        System.out.println("-----");
    }

    public LFUCache(int capacity) {
        cap = capacity;
        minFreq = 0;
        keyToValMap = new HashMap<>();
        keyToFreqMap = new HashMap<>();
        freqToKeySet = new HashMap<>();
    }

    private void addFreq(int key) {
        int freq = keyToFreqMap.get(key);
        keyToFreqMap.put(key, freq + 1);

        // 从旧的链表删除
        Set<Integer> oldSet = freqToKeySet.get(freq);
        oldSet.remove(key);
        if (oldSet.isEmpty()) {
            freqToKeySet.remove(freq);
            if (freq == minFreq) {
                minFreq = freq + 1;
            }
        }

        // 添加到新的链表
        freqToKeySet.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeySet.get(freq + 1).add(key);
    }


    public int get(int key) {
        if (!keyToValMap.containsKey(key)) {
            return -1;
        }

        addFreq(key);

        return keyToValMap.get(key);

    }

    /**
     * 添加频率
     */
    private void setFreq(int key) {
        LinkedHashSet<Integer> freqOfOne = freqToKeySet.get(1);
        if (freqOfOne == null) {
            freqOfOne = new LinkedHashSet<>();
        }
        freqOfOne.add(key);
        freqToKeySet.put(1, freqOfOne);
        keyToFreqMap.put(key, 1);
        minFreq = 1;
    }

    private void addValue(int key, int val) {
        keyToValMap.put(key, val);
        setFreq(key);
    }

    /**
     *
     */
    private void removeLeast() {
        Set<Integer> set = freqToKeySet.get(minFreq);
        Iterator<Integer> iterator = set.iterator();
        int lastKey = iterator.next();
        set.remove(lastKey);
        // 为空则移除整个set
        if (set.isEmpty()) {
            freqToKeySet.remove(minFreq);
        }

        keyToValMap.remove(lastKey);
        keyToFreqMap.remove(lastKey);

    }


    public void put(int key, int value) {

        if (cap <= 0) {
            return;
        }

        // key已存在
        if (keyToValMap.containsKey(key)) {
            // 更新value
            keyToValMap.put(key, value);
            addFreq(key);
        } else {// key不存在
            // 容量已满 淘汰机制
            if (keyToValMap.size() == cap) {
                removeLeast();
            }
            // 添加
            addValue(key, value);
        }

    }
}

/**
 * 测试
 */
class LFUTest {

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.print();
        lfu.put(3, 3);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.print();
        lfu.put(4, 4);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.print();
        lfu.get(4);      // return 1
        lfu.print();
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
