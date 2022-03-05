package leetcode.solution.DataStruct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 */
public class LRUCache {

    /**
     * 哈希表，可以O(1)复杂度找到节点
     */
    private static Map<Integer, Node> hashMap;

    /**
     * 双向链表
     */
    private static VList vList;

    /**
     * 容量
     */
    private static int cap;

    /**
     * 私有方法
     * 在HashMap中根据key获取节点
     *
     * @param key
     * @return
     */
    private static Node getNode(int key) {
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        return null;
    }

    /**
     * 更新节点
     * <p>
     * 即把节点移到链表末尾（先删除，后添加，时间复杂度都是O(1)）
     *
     * @param node
     */
    private static void makeNew(Node node) {
        vList.delete(node);
        vList.add(node);
    }

    /**
     * 删除最老未使用元素
     */
    private static void deleteOldest() {
        int key = vList.deleteLeft();
        hashMap.remove(key);
    }

    /**
     * 添加新元素
     */
    private static void add(int key, int val) {
        int size = vList.getSize();
        // 容量已达上限
        if (size == cap) {
            deleteOldest();
        }
        Node node = new Node(key, val);
        hashMap.put(key, node);
        vList.add(node);
    }

    /**
     * 更新元素
     * <p>
     * 已存在key，则只需要更新val, 然后将节点放在链表末尾
     *
     * @param key
     * @param val
     */
    private static void update(int key, int val) {
        Node node = hashMap.get(key);
        node.val = val;
        makeNew(node);
    }

    /**
     * 构造函数
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        vList = new VList();
        hashMap = new HashMap<>();
        cap = capacity;
    }

    /**
     * 获取元素值
     *
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }

        makeNew(node);
        return node.val;
    }

    /**
     * 添加/更新元素值
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            update(key, value);
        } else {
            add(key, value);
        }
    }
}

/**
 * 节点定义
 * 包含key,val以及前后指针
 */
class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node() {

    }

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

/**
 * 双向链表定义
 */
class VList {
    /**
     * 头尾节点
     */
    private Node head;

    private Node tail;
    /**
     * 链表实际大小
     */
    private int size;

    public VList() {
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取链表大小
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 插入新节点尾部
     *
     * @param node
     */
    public void add(Node node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    /**
     * 删除节点（只需改变指针指向）
     *
     * @param node
     */
    public void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    /**
     * 删除最左边元素，即为最久未访问元素
     * 删除节点，同时返回该节点的key，便于在HashMap中删除元素
     *
     * @return
     */
    public int deleteLeft() {
        Node oldest = head.next;
        delete(oldest);
        return oldest.key;
    }


}


/**
 * 直接利用Java中LinkedHashMap实现
 */
class LRUCache1 {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache1(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * 测试
 */
class Test1 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        int a = lRUCache.get(1);    // return 1
        System.out.println(lRUCache.get(2));
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
