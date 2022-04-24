package leetcode.solution.DataStruct;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. Design Underground System
 */
public class DesignUndergroundSystem {

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        double ans = undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        System.out.println(ans);
        ans = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        System.out.println(ans);
        undergroundSystem.checkIn(10, "Leyton", 24);
        ans = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        System.out.println(ans);
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        ans = undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
        System.out.println(ans);
    }
}

class UndergroundSystem {

    /**
     * save the checkIn record
     * <p>
     * key is the id of customer
     * the key of Pair is stationName, the value of Pair is t
     */
    Map<Integer, Pair<String, Integer>> checkMap;

    /**
     * save the total time and number of times so far between startStation and endStation
     * <p>
     * key is the combination of startStation and endStation
     * the key of Pair is total time, the value of Pair is the number of times
     */
    Map<String, Pair<Integer, Integer>> resMap;

    public UndergroundSystem() {
        checkMap = new HashMap<>();
        resMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Pair<String, Integer> pair = new Pair<>(stationName, t);
        checkMap.put(id, pair);
    }

    public void checkOut(int id, String stationName, int t) {
        if (!checkMap.containsKey(id)) {
            return;
        }

        Pair<String, Integer> check = checkMap.get(id);
        int intervalTime = t - check.getValue();
        // join the station with '-' as the key
        String station = check.getKey() + "-" + stationName;

        if (resMap.containsKey(station)) {
            Pair<Integer, Integer> existPair = resMap.get(station);
            int totalTime = existPair.getKey() + intervalTime;
            int count = existPair.getValue() + 1;
            resMap.put(station, new Pair<>(totalTime, count));
        } else {
            resMap.put(station, new Pair<>(intervalTime, 1));
        }

        // clean the map to save space.
        checkMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String station = startStation + "-" + endStation;
        Pair<Integer, Integer> data = resMap.get(station);
        return (double) data.getKey() / data.getValue();
    }
}
