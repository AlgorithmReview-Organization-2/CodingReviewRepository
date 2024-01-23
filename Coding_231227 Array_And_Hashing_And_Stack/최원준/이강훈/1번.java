/*
https://leetcode.com/problems/time-based-key-value-store/submissions/1131173864/

아이디어
key -> timestamp -> value 구현
 (timestamp : value) TreeMap 을 통해 정렬, 가장 작지만 가장 가까운 timestamp 이분탐색 (floorEntry)

자료구조
HashMap, TreeMap

시간복잡도
O (N log N)
*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, o1 -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        String answer = "";

        if (map.containsKey(key)) {
            TreeMap<Integer, String> subMap = map.get(key);

            // 일치하는 시간
            if (subMap.containsKey(timestamp)) return subMap.get(timestamp);

            // 가장 가까운 시간
            Map.Entry<Integer, String> entry = subMap.floorEntry(timestamp);
            if (entry != null) {
                answer = entry.getValue();
            }
        }

        return answer;
    }
}