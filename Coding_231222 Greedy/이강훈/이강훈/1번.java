/*
https://www.acmicpc.net/problem/1339

아이디어
각 문자 별 자리 수 총합 구하고
 큰 문자부터 9 할당

자료구조
배열

시간복잡도
O(length * N)
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                arr[c - 'A'] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        int num = 9;
        int index = 25;
        int ans = 0;
        while (arr[index] != 0) {
            ans += arr[index] * num;
            index--;
            num--;
        }

        System.out.print(ans);
    }
}
