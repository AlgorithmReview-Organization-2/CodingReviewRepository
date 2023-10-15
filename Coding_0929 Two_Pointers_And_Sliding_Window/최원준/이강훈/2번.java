/*
https://leetcode.com/problems/permutation-in-string/

아이디어
s1 Map 카운트 후 투포인터 .. 비효율적인 부분이 있는 것 같음
 아 어렵다

자료구조
HashMap

시간복잡도
O(N)
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> orgMap = new HashMap<>();

        for (char c : s1.toCharArray()) {
            orgMap.put(c, orgMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new HashMap<>(Map.copyOf(orgMap));

        int s1Length = s1.length();
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            if (map.containsKey(s2.charAt(r))) {
                map.put(s2.charAt(r), map.get(s2.charAt(r)) - 1);
                s1Length--;

                if (map.get(s2.charAt(r)) < 0) {
                    while (s2.charAt(l) != s2.charAt(r)) {
                        map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                        s1Length++;
                        l++;
                    }
                    map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                    s1Length++;
                    l++;
                }
            } else {
                map = new HashMap<>(Map.copyOf(orgMap));
                s1Length = s1.length();

                l = r + 1;
            }

            if (s1Length == 0) return true;
        }

        return false;
    }
}
