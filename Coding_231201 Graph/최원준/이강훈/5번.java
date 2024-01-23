/*
https://leetcode.com/problems/find-eventual-safe-states/

아이디어
out 방향 없는 노드부터 BFS 시작
 -> 터미널 노드로 들어오는 노드들의 out 방향 목록에서 해당 터미널 노드를 제거 ( BFS 반복 )
  -> out 방향 목록 비워지는 노드들만 같은 작업 반복

자료구조
큐, HashMap

시간복잡도
O(N)
*/

import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        Map<Integer, List<Integer>> inMap = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            outMap.put(i, new ArrayList<>());
            inMap.putIfAbsent(i, new ArrayList<>());

            for (int adj : graph[i]) {
                outMap.computeIfAbsent(i, key -> new ArrayList<>()).add(adj);
                inMap.computeIfAbsent(adj, key -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, List<Integer>> entry : outMap.entrySet()) {
            if (entry.getValue().size() == 0) queue.add(entry.getKey());
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (outMap.get(node).size() == 0) {
                for (int inNode : inMap.get(node)) {
                    outMap.get(inNode).remove((Integer) node);

                    if (outMap.get(inNode).size() == 0) queue.add(inNode);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : outMap.entrySet()) {
            if (entry.getValue().size() == 0) answer.add(entry.getKey());
        }

        return answer;
    }
}
