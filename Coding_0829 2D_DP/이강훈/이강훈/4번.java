/*
https://www.acmicpc.net/problem/1937

아이디어
dfs 카운트

자료구조
2차원 배열

시간복잡도
O(N * N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] pos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    static int[][] answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new int[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (answer[i][j] == 0) dfs(i, j, 1);
            }
        }

        System.out.println(Arrays.stream(answer).flatMapToInt(Arrays::stream).max().getAsInt());
    }

    public static int dfs(int x, int y, int value) {
        int depth = value;

        for (int i = 0; i < 4; i++) {
            int newx = x + pos[i][0];
            int newy = y + pos[i][1];

            if (newx < 0 || newy < 0 || newx >= N || newy >= N) continue;
            if (map[newx][newy] <= map[x][y]) continue;
            if (answer[newx][newy] != 0) {
                depth = Math.max(depth, answer[newx][newy] + 1);
                continue;
            }

            depth = Math.max(depth, dfs(newx, newy, value) + 1);
        }

        answer[x][y] = Math.max(answer[x][y], depth);

        return answer[x][y];
    }
}
