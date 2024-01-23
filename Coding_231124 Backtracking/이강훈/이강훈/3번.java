/*
https://school.programmers.co.kr/learn/courses/30/lessons/43164

1. 아이디어
백트래킹 구현

2. 자료구조
배열

3. 시간 복잡도
O(N!)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static boolean[] visited;
    private static List<String> result = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        backtrack(0, "ICN", "ICN", tickets);
        Collections.sort(result);

        String[] answer = result.get(0).split(" ");
        return answer;
    }

    public static void backtrack(int index, String start, String route, String[][] tickets) {
        if (index == tickets.length) {
            result.add(route);

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                backtrack(index + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}