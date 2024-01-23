/*
https://school.programmers.co.kr/learn/courses/30/lessons/172927

1. 아이디어
백트래킹 구현 (사용 곡갱이 수, 사용 미네랄 수, 비용)

2. 자료구조
배열

3. 시간 복잡도
O(N * M) // N = 곡갱이 수, M = 미네랄 수
*/

import java.util.Arrays;

public class Solution {
    int[] picks;
    String[] minerals;
    int answer = Integer.MAX_VALUE;
    int totalPick;
    int[][] costByPick = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        this.totalPick = Arrays.stream(picks).sum();

        backtrack(0, 0, 0);

        return answer;
    }

    public void backtrack(int usedPick, int usedMineral, int cost) {
        if (usedPick == totalPick || usedMineral == minerals.length) {
            answer = Math.min(answer, cost);

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int currentCost = 0;

                int j = usedMineral;
                for (; j < Math.min(usedMineral + 5, minerals.length); j++) {
                    if (minerals[j].equals("diamond")) currentCost += costByPick[i][0];
                    else if (minerals[j].equals("iron")) currentCost += costByPick[i][1];
                    else if (minerals[j].equals("stone")) currentCost += costByPick[i][2];
                }

                picks[i]--;
                backtrack(usedPick + 1, j, cost + currentCost);
                picks[i]++;
            }
        }
    }
}