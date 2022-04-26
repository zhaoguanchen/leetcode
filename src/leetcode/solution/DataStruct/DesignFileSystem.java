package leetcode.solution.DataStruct;

import java.util.HashMap;

/**
 * 1166. Design File System
 */
public class DesignFileSystem {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        boolean ans1 = fileSystem.createPath("/leet", 1); // return true
        System.out.println(ans1);
        ans1 = fileSystem.createPath("/leet/code", 2); // return true
        System.out.println(ans1);
        int ans = fileSystem.get("/leet/code"); // return 2
        System.out.println(ans);
        ans1 = fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
        System.out.println(ans1);

        ans = fileSystem.get("/c"); //
        System.out.println(ans);
    }
}


class FileSystem {

    FileSystemNode root;

    public FileSystem() {
        root = new FileSystemNode();
    }

    public boolean createPath(String path, int value) {
        String[] pathArr = path.split("/");

        FileSystemNode p = root;
        for (int i = 1; i < pathArr.length; i++) {
            if (!p.map.containsKey(pathArr[i])) {
                // if it is the last part, put it
                if (i == pathArr.length - 1) {
                    p.map.put(pathArr[i], new FileSystemNode());
                } else {
                    // parent path not exist. failed.
                    return false;
                }
            }

            // move to leaf
            p = p.map.get(pathArr[i]);
        }

        // already existed.
        if (p.val != -1) {
            return false;
        }

        // set value
        p.val = value;
        return true;
    }

    public int get(String path) {
        String[] pathArr = path.split("/");

        FileSystemNode p = root;
        for (int i = 1; i < pathArr.length; i++) {
            // path not exist.
            if (!p.map.containsKey(pathArr[i])) {
                return -1;
            }
            p = p.map.get(pathArr[i]);
        }

        // p is the node of last path of path
        return p.val;
    }
}


class FileSystemNode {
    /**
     * value. default -1 because 1 <= value <= 109
     */
    int val = -1;

    /**
     * Using HashMap as the children list.
     */
    HashMap<String, FileSystemNode> map = new HashMap<>();
}