/*
https://school.programmers.co.kr/learn/courses/30/lessons/42898#

아이디어
우측, 하단 합

자료구조
배열

시간복잡도
O(NM)
*/

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        map[0][0] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == -1) continue;

                if (j + 1 < m && map[i][j + 1] != -1) {
                    map[i][j + 1] += map[i][j];
                    map[i][j + 1] %= 1000000007;
                }

                if (i + 1 < n && map[i + 1][j] != -1) {
                    map[i + 1][j] += map[i][j];
                    map[i + 1][j] %= 1000000007;
                }
            }
        }

        return map[n - 1][m - 1];
    }
}
