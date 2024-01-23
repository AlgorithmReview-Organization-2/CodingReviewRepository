/*
https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

아이디어
정방향 / 역방향 그래프 저장 후 dfs 계산
 ( 0 에서 정방향 이동 시 비용 추가 )

자료구조
HashMap

시간복잡도
O(V + E)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    List<Integer> temp = IntStream.of(0).boxed().collect(Collectors.toList());
    Map<Integer, List<Integer>> directionMap = new HashMap<>();
    Map<Integer, List<Integer>> reverseMap = new HashMap<>();
    boolean[] visited;
    int answer = 0;

    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];

        for (int[] connection : connections) {
            directionMap.computeIfAbsent(connection[0], key -> new ArrayList<>()).add(connection[1]);
            reverseMap.computeIfAbsent(connection[1], key -> new ArrayList<>()).add(connection[0]);
        }

        dfs(0);

        return answer;
    }

    public void dfs(int node) {
        visited[node] = true;

        for (int adj : directionMap.getOrDefault(node, temp)) {
            if (visited[adj]) continue;

            answer++;
            dfs(adj);
        }

        for (int adj : reverseMap.getOrDefault(node, temp)) {
            if (visited[adj]) continue;

            dfs(adj);
        }
    }
}
