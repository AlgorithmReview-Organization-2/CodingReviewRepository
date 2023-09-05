/*
https://www.acmicpc.net/problem/15724

아이디어
row 마다 누적 합 DP
--> 로직 수정
---> row 마다 2차원으로 누적합 계산이 아니라 단순 합 구하고 마지막에서 계산

자료구조
2차원 배열

시간복잡도
O(N * M * M) -> 계산 상 최악이 10초.. 될려나 = 실패~
--> 로직 수정
---> O ( K * N ) -> 최악이 1초네.. 흠
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                map[i][j] = map[i][j - 1];
                map[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int total = 0;
            for (int j = x1; j <= x2; j++) {
                total += map[j][y2] - map[j][y1 - 1];
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
