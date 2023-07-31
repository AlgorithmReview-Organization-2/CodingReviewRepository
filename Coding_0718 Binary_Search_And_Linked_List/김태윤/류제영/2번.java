# https://www.acmicpc.net/problem/2512

'''
1. 아이디어 :
    이분 탐색으로 계산, 최댓값이므로 max를 출력
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :

'''

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());

        int min = 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            int sum = 0;
            for (int money : arr) {
                sum += Math.min(money, mid);
            }

            if (sum > M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}
