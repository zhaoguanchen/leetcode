package leetcode.solution.DataStruct;

import java.util.LinkedList;

/**
 * 705. Design HashSet
 */
public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        boolean ans = myHashSet.contains(1); // return True
        System.out.println(ans);
        ans = myHashSet.contains(3); // return False, (not found)
        System.out.println(ans);
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }


}

/**
 * implement with Array + LinkedList
 */
class MyHashSet {


    Bucket[] array;

    int size;

    public MyHashSet() {
        size = 768;
        array = new Bucket[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Bucket();
        }
    }


    private int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int index = hash(key);
        array[index].add(key);
    }

    public void remove(int key) {
        int index = hash(key);
        array[index].remove(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return array[index].contains(key);
    }
}


class Bucket {
    LinkedList<Integer> list;

    public Bucket() {
        list = new LinkedList<>();
    }

    public void add(Integer key) {
        if (!list.contains(key)) {
            list.addFirst(key);
        }
    }

    public void remove(Integer key) {
        list.remove(key);
    }

    public boolean contains(Integer key) {
        return list.contains(key);
    }


}