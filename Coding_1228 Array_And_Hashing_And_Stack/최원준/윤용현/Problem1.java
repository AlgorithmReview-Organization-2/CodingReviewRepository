import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/time-based-key-value-store/description/
// TC: Set(O(1)), Get(O(logN))
// SC: O(N)
public class Problem1 {
}

class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> timeMap = map.get(key);
        Integer floor = timeMap.floorKey(timestamp);
        return (floor == null) ? "" : timeMap.get(floor);
    }
}
