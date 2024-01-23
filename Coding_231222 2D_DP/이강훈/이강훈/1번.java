/*
https://school.programmers.co.kr/learn/courses/30/lessons/136797

아이디어
숫자 - 숫자 이동 비용 저장 활용
 -> 비용이 동일하면 양손 경우 비교

자료구조
배열

시간복잡도
O(N)
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    int[][] cost = new int[10][10];
    int[][] phone = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    int[][] pos = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    int[][][] dp;
    String numbers;

    public int solution(String numbers) {
        this.numbers = numbers;
        dp = new int[numbers.length()][10][10];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int target = 0; target < 10; target++) {
                    int start = phone[i][j];

                    if (start == -1) continue;

                    cost[start][target] = bfs(i, j, target, 0);
                }
            }
        }

        return calculate(0, 4, 6);
    }

    public int bfs(int x, int y, int target, int count) {
        boolean[][] visited = new boolean[4][3];

        Queue<Integer> queue = new LinkedList<>(List.of(x, y, count));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int myX = queue.poll();
            int myY = queue.poll();
            int cost = queue.poll();

            if (phone[myX][myY] == target) return cost == 0 ? 1 : cost;

            for (int i = 0; i < 8; i++) {
                int newX = myX + pos[i][0];
                int newY = myY + pos[i][1];

                if (newX < 0 || newY < 0 || newX >= 4 || newY >= 3) continue;
                if (visited[newX][newY]) continue;

                if (i < 4)
                    queue.addAll(List.of(newX, newY, cost + 2));
                else
                    queue.addAll(List.of(newX, newY, cost + 3));

                visited[newX][newY] = true;
            }
        }

        return -1;
    }

    public int calculate(int index, int left, int right) {
        if (index == numbers.length()) return 0;
        if (dp[index][left][right] != 0) return dp[index][left][right];

        int target = Integer.parseInt(String.valueOf(numbers.charAt(index)));

        int leftCost = cost[left][target];
        int rightCost = cost[right][target];

        int result = 0;
        if (leftCost == rightCost) {
            result = Math.min(
                    calculate(index + 1, target, right) + leftCost,
                    calculate(index + 1, left, target) + rightCost);
        } else if (leftCost < rightCost) {
            result = calculate(index + 1, target, right) + leftCost;
        } else {
            result = calculate(index + 1, left, target) + rightCost;
        }

        dp[index][left][right] = result;
        return result;
    }
}
