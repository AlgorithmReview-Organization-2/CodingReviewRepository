/*
https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

아이디어
dp + dfs

자료구조
배열

시간복잡도
O (nm) // dp 로 중복 dfs 제거
*/

public class Solution {
    int[][] pos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] dy;
    int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        dy = new int[matrix.length][matrix[0].length];

        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        return answer;
    }

    public int dfs(int x, int y) {
        if (dy[x][y] != 0) return dy[x][y];

        int count = 1;
        for (int i = 0; i < 4; i++) {
            int newx = x + pos[i][0];
            int newy = y + pos[i][1];

            if (newx < 0 || newy < 0 || newx >= matrix.length || newy >= matrix[0].length) continue;
            if (matrix[x][y] <= matrix[newx][newy]) continue;

            count = Math.max(count, dfs(newx, newy) + 1);
        }

        dy[x][y] = count;
        return dy[x][y];
    }
}
