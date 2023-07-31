# https://www.acmicpc.net/problem/1654

'''
1. 아이디어 :
    이분 탐색으로 계산
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long min = 1;
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }

            if (count >= N) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(max);
    }
}
