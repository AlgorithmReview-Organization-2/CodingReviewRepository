/*
https://www.acmicpc.net/problem/2018

아이디어
투포인터

자료구조
변수

시간복잡도
O(N)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1;
        int sum = 1;
        int answer = 0;
        while (left <= N) {
            while (right < N && sum < N) {
                right++;
                sum += right;
            }

            if (sum == N) answer++;

            sum -= left;
            left++;
        }

        System.out.println(answer);
    }
}
