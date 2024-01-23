// ( 나랑 문제 중복 )

/*
https://www.acmicpc.net/problem/2512

아이디어
이분 탐색 - 파라미터 탐색

자료구조
배열

시간복잡도
O(N log N)
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

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            list.add(num);
            max = Math.max(max, num);
        }

        int M = Integer.parseInt(br.readLine());

        int L = 0;
        int R = max + 1;
        int total = 0;
        while (L < R) {
            int mid = (L + R) / 2;

            for (int num : list) {
                total += Math.min(num, mid);
            }

            if (total <= M) L = mid + 1;
            else R = mid;

            total = 0;
        }

        System.out.println(R - 1);
    }
}
