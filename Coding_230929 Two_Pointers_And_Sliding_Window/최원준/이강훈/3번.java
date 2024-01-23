/*
https://leetcode.com/problems/minimum-window-substring/

아이디어
tLength 저장해두고 s에서 t 에 일치하는 문자 찾으면 tLength 줄임
tlength 0 되면 최소 길이인 경우 정답 갱신

만약 중복 문자 나오면 중복 문자 없는 경우로 갱신

.. 근데 실패, 원준이형 영상 봤는데 중복은 상관 안써야되고 Map 으로 비교하는게 맞는 방법인듯한데 아예 바꿔야되네

자료구조
HashMap

시간복잡도
O(N)
*/

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int tLength = t.length();
        int subLength = 0;
        int minLength = Integer.MAX_VALUE;
        boolean firstFind = false;
        String answer = "";
        for (int r = 0; r < s.length(); r++) {
            subLength++;

            if (tMap.containsKey(s.charAt(r))) {
                if (!firstFind) {
                    l = r;

                    firstFind = true;
                }
                tMap.put(s.charAt(r), tMap.get(s.charAt(r)) - 1);
                tLength--;

                if (tLength == 0 || tMap.get(s.charAt(r)) < 0) {
                    // 중복된 문자가 나온 경우 subString 중 중복된 문자 위치까지 l 떙겨옴
                    if (tMap.get(s.charAt(r)) < 0) {
                        while (s.charAt(l) != s.charAt(r)) {
                            if (tMap.containsKey(s.charAt(l))) {
                                tMap.put(s.charAt(l), tMap.get(s.charAt(l)) + 1);
                                tLength++;
                            }
                            subLength--;
                            l++;
                        }
                    }

                    // subString 완성한 경우
                    if (tLength == 0 && subLength < minLength) {
                        answer = s.substring(l, r + 1);

                        minLength = subLength;
                    }

                    // 위 두 경우 모두 l 을 다음 일치하는 문자까지 떙겨와야 함
                    tMap.put(s.charAt(l), tMap.get(s.charAt(l)) + 1);
                    tLength++;

                    subLength--;
                    l++;
                    while (l <= r && !tMap.containsKey(s.charAt(l))) {
                        subLength--;
                        l++;
                    }
                }
            }
        }

        return answer;
    }
}