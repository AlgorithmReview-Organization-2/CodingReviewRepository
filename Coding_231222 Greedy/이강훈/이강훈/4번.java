/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861

아이디어
공통 그룹을 최종 부모를 같게해서 계산
 -> 코스트가 가장 적은 다리부터 사용하면서 노드 부모 통일 ( 그룹화 )

자료구조
배열

시간복잡도
O (N log N)
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int[] parents;

    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int answer = 0;
        for (int[] cost : costs) {
            int node1Parent = findParent(cost[0]);
            int node2Parent = findParent(cost[1]);

            if (node1Parent == node2Parent) continue;

            calculateParent(node1Parent, node2Parent);
            answer += cost[2];
        }

        return answer;
    }

    public int findParent(int node) {
        if (parents[node] == node) return node;

        return findParent(parents[node]);
    }

    public void calculateParent(int node1Parent, int node2Parent) {
        if (node1Parent > node2Parent) {
            parents[node1Parent] = node2Parent;
        } else {
            parents[node2Parent] = node1Parent;
        }
    }
}
