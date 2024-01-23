/*
https://www.acmicpc.net/problem/1072

아이디어
이분 탐색
-> float 사용 시 소수 점 제한때문인지 수가 커지면 이상한 값이 나옴 조심
 -> 근데 안되네? 이유를 모르겠음

자료구조
변수

시간복잡도
O(log x)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int winRate = (int) (((double) y / x) * 100);

        int l = 0;
        int r = x;
        while (l < r) {
            int m = (l + r) / 2;

            if ((int) (((double) (y+m) / (x+m)) * 100) > winRate ) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        System.out.println(r == x ? -1 : r);
    }
}
