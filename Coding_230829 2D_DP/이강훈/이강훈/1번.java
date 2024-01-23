/*
https://www.acmicpc.net/problem/2167

아이디어
모든 경우의 누적 합 DP

자료구조
ArrayList + 2차원 배열

시간복잡도
O(N * M * M)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<int[][]> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            int[][] totalRow = new int[M][M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());

                for (int k = 0; k <= j; k++) {
                    totalRow[k][j] += num;

                    if (j != 0) totalRow[k][j] += totalRow[k][j-1];
                }
            }

            list.add(totalRow);
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int total = 0;
            for (int j = x1; j <= x2; j++) {
                total += list.get(j)[y1][y2];
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
