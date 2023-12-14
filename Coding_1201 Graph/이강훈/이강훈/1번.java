/*
https://school.programmers.co.kr/learn/courses/30/lessons/43163

아이디어
단어별로 변경 가능한 단어 목록 저장
 -> BFS

자료구조
큐, Hash

시간복잡도
O(
*/

import java.util.*;

public class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> cost = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        // 1글자 다른 목록 Map, 비용 저장 Map 생성
        for (int i = -1; i < words.length; i++) {
            String str1 = i == -1 ? begin : words[i];

            cost.put(str1, 0);

            compareLoop:
            for (int j = i + 1; j < words.length; j++) {
                String str2 = words[j];

                int misMatch = 0;
                for (int k = 0; k < str1.length(); k++) {
                    if (str1.charAt(k) != str2.charAt(k)) misMatch++;
                    if (misMatch > 1) continue compareLoop;
                }

                if (misMatch == 1) {
                    map.computeIfAbsent(str1, key -> new ArrayList<>()).add(str2);
                    map.computeIfAbsent(str2, key -> new ArrayList<>()).add(str1);
                }
            }
        }

        // 정답 불가능한 경우
        if (!cost.containsKey(target)) return 0;

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        visited.add(begin);

        bfsLoop:
        while (!queue.isEmpty()) {
            String node = queue.poll();


            for (String adj : map.get(node)) {
                if (visited.contains(adj)) continue;

                queue.add(adj);
                visited.add(adj);
                cost.put(adj, cost.get(node) + 1);

                if (adj.equals(target)) break bfsLoop;
            }
        }

        return cost.get(target);
    }
}
