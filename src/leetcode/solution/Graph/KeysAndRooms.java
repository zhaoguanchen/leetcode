package leetcode.solution.Graph;

import java.util.*;

/**
 * 841. Keys and Rooms
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Collections.singletonList(1));
        rooms.add(Collections.singletonList(2));
        rooms.add(Collections.singletonList(3));
        rooms.add(new ArrayList<>());

        KeysAndRoomsSolution solution = new KeysAndRoomsSolution();
        boolean ans = solution.canVisitAllRooms(rooms);
        System.out.println(ans);
        // true
    }


}

class KeysAndRoomsSolution {

    private Set<Integer> visited;

    List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new HashSet<>();
        this.rooms = rooms;

        // traverse form node 0
        visited.add(0);
        for (int i = 0; i < rooms.get(0).size(); i++) {
            dfs(rooms.get(0).get(i));
        }

        // all rooms have been visited
        return rooms.size() == visited.size();
    }


    private void dfs(Integer room) {
        // visited
        if (visited.contains(room)) {
            return;
        }

        if (rooms.size() == visited.size()) {
            return;
        }

        // mark as visited
        visited.add(room);

        // traverse neighbors
        for (int i = 0; i < rooms.get(room).size(); i++) {
            dfs(rooms.get(room).get(i));
        }

    }
}
