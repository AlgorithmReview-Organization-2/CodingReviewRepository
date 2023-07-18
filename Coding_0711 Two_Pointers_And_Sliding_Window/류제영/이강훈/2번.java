/*
https://www.acmicpc.net/problem/1806
0.5초 - 128MB
N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)
각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수

아이디어
투 포인터 - 슬라이딩 윈도

자료구조
배열

시간 복잡도
O(N)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while (true) {
            if (sum < S) {
                if (R == N) break;

                sum += nums[R];
                R++;
            } else {
                answer = Math.min(answer, R - L);

                sum -= nums[L];
                L++;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
