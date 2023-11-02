/*
https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

아이디어
dfs
 -> Apple 인 노드 혹은 true 를 반환환 간선이 있다면 true 를 반환, true 를 반환받은 간선은 지나가야하는 간선임
  -> 그래서 true 를 반환받은 간선의 총 개수를 세고 2 를 곱한 것이 정답

자료구조
HashMap, ArrayList

시간복잡도
O(N) // N == 간선 수, 입력 조건이 간선 수는 노드 수 - 1
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    boolean[] visited;

    List<Boolean> hasApple;

    int findApple = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (edges.length == 0) return 0;

        visited = new boolean[n];
        this.hasApple = hasApple;

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        findApple(0, false);

        return findApple * 2;
    }

    public boolean findApple(int node, boolean isFindApple) {
        visited[node] = true;

        for (int adj : map.get(node)) {
            if (visited[adj]) continue;

            if (findApple(adj, false)) {
                isFindApple = true;
                findApple++;
            }
        }

        if (hasApple.get(node)) isFindApple = true;

        return isFindApple;
    }
}
