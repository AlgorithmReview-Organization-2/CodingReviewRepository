/*
https://school.programmers.co.kr/learn/courses/30/lessons/87694

아이디어
지도 2배로 그리고 dfs
 -> 지도 0 = 초기값, 1 = 테두리, 2 = 도형 내부
  -> 겹치면 테두리는 그리지 않고 ( 0 인 곳에만 테두리 그림 ) 내용은 항상 채우게 진행 ( 기존 테두리 겹치면 내용으로 없애기 )

자료구조
배열

시간복잡도
O(M * N)
*/

public class Solution {
    int[][] map;
    boolean[][] visited;
    int[][] pos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int answer = Integer.MAX_VALUE;
    int itemX;
    int itemY;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        this.itemX = itemX;
        this.itemY = itemY;

        for (int[] figure : rectangle) {
            maxX = Math.max(maxX, figure[2]);
            maxY = Math.max(maxY, figure[3]);
        }

        map = new int[++maxY * 2][++maxX * 2];
        visited = new boolean[maxY * 2][maxX * 2];

        // 지도 그리기
        // 0 = 초기 , 1 = 테두리 , 2 = 도형 내부
        for (int[] figure : rectangle) {
            int x1 = figure[0] * 2;
            int y1 = figure[1] * 2;
            int x2 = figure[2] * 2;
            int y2 = figure[3] * 2;

            // 세로 변 테두리 그리기
            for (int i = y1; i <= y2; i++) {
                if (map[i][x1] == 0) map[i][x1] = 1;
                if (map[i][x2] == 0) map[i][x2] = 1;
            }

            // 가로 변 테두리 그리기
            for (int i = x1; i <= x2; i++) {
                if (map[y1][i] == 0) map[y1][i] = 1;
                if (map[y2][i] == 0) map[y2][i] = 1;
            }

            // 내부 채우기
            for (int i = y1 + 1; i < y2; i++) {
                for (int j = x1 + 1; j < x2; j++) {
                    map[i][j] = 2;
                }
            }
        }

        dfs(characterY * 2, characterX * 2, 0);

        return answer;
    }

    public void dfs(int y, int x, int count) {
        if (y == itemY * 2 && x == itemX * 2) {
            answer = Math.min(answer, count);
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newy = y + pos[i][0];
            int newx = x + pos[i][1];

            if (newy < 0 || newx < 0 || newy + 1 >= map.length || newx + 1 >= map[0].length) continue;
            if (map[newy][newx] != 1) continue;

            newy += pos[i][0];
            newx += pos[i][1];
            if (visited[newy][newx]) continue;

            dfs(newy, newx, count + 1);
        }

        visited[y][x] = false;
    }
}
