/*
https://www.acmicpc.net/problem/10844

아이디어
DP -> 각 자리수마다 끝나는 1의 자리 카운트 수가 다음 수의 경우의 수를 결정

자료구조
2차원 배열

시간복잡도
O(N * 10)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dy = new long[N][10];
        dy[0] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dy[i][j] = dy[i - 1][j + 1];
                } else if (j == 9) {
                    dy[i][j] = dy[i - 1][j - 1];
                } else {
                    dy[i][j] += dy[i - 1][j - 1];
                    dy[i][j] += dy[i - 1][j + 1];
                }

                dy[i][j] %= 1000000000;
            }
        }

        System.out.println(Arrays.stream(dy[N - 1]).sum() % 1000000000);
    }
}
