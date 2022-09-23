package leetcode.solution.DataStruct;

import java.util.PriorityQueue;

/**
 * 2102. Sequentially Ordinal Rank Tracker
 */
public class SequentiallyOrdinalRankTracker {

    public static void main(String[] args) {
        SORTracker tracker = new SORTracker();
        tracker.add("bradford", 2);
        tracker.add("branford", 3);
        tracker.add("aa", 5);
        tracker.add("av", 5);
        tracker.add("c", 15);
        tracker.add("c", 1);
    }


}

class SORTracker {

    private PriorityQueue<Entity> minHeap;

    private PriorityQueue<Entity> maxHeap;


    public SORTracker() {
        // candidate element
        this.maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) {
                return a.name.compareTo(b.name);
            }
            return b.score - a.score;
        });

        // processed element
        this.minHeap = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) {
                return b.name.compareTo(a.name);
            }
            return a.score - b.score;
        });

    }

    public void add(String name, int score) {
        Entity entity = new Entity(name, score);
        minHeap.add(entity);
        maxHeap.add(minHeap.poll());
    }

    public String get() {
        Entity candidate = maxHeap.poll();
        minHeap.add(candidate);
        return candidate.name;
    }
}


class Entity {

    int score;
    String name;

    public Entity(String name, int score) {
        this.name = name;
        this.score = score;
    }
}