# https://www.acmicpc.net/problem/2805

'''
1. 아이디어 :
    이분 탐색으로 계산하고, 최댓값을 출력
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static voida main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int min = 0;
        while (min <= max) {
            int mid = (min + max) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) sum += arr[i] - mid;
            }

            if (sum >= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }
}
