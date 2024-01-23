/*
https://leetcode.com/problems/longest-repeating-character-replacement/

아이디어
이것저것 해보다 도저히 안대서 원준이형 강의 영상보고 풀이
 .. 풀이 봤는데도 이해가 안된다. l 이 증가될 때 maxCount 가 갱신되어야 하는거 아닌가?

자료구조
HashMap

시간복잡도
O(n)
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxCount = 0;
        int length = 0;
        int answer = 0;

        for (int r = 0; r < s.length(); r++) {
            length++;

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(r)));

            while (length - maxCount > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);

                l++;
                length--;
            }

            answer = Math.max(answer, length);
        }

        return answer;
    }
}