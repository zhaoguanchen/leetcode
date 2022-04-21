package leetcode.solution.DataStruct;

import java.util.LinkedList;

/**
 * 706. Design HashMap
 */
public class DesignHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        int ans = myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(ans);
        myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        ans = myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        System.out.println(ans);
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]    }


    }
}

/**
 * implement with Array + LinkedList
 */
class MyHashMap {

    private HashMapBucket[] array;

    private int size;

    public MyHashMap() {
        size = 768;
        array = new HashMapBucket[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = new HashMapBucket();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        array[index].put(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        return array[index].get(key);

    }

    public void remove(int key) {
        int index = hash(key);
        array[index].remove(key);

    }
}


class HashMapData {
    private Integer k;

    private Integer v;

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}

class HashMapBucket {
    LinkedList<HashMapData> list;

    public HashMapBucket() {
        list = new LinkedList<>();
    }

    public void put(int key, int value) {
        for (HashMapData data : list) {
            if (data.getK() == key) {
                data.setV(value);
                return;
            }
        }

        HashMapData newData = new HashMapData();
        newData.setK(key);
        newData.setV(value);
        list.addFirst(newData);
    }

    public int get(int key) {
        for (HashMapData data : list) {
            if (data.getK() == key) {
                return data.getV();
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (HashMapData data : list) {
            if (data.getK() == key) {
                list.remove(data);
                // to avoid ConcurrentModificationException, break is very important!
                break;
            }
        }
    }

}