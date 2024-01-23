/*
https://www.acmicpc.net/problem/9934

아이디어
in order 의 규칙 찾기 -> zero-index % 2^depth = ( 2^depth / 2 ) - 1 // depth 를 K ~ 1 모두 비교 ( 큰 K 부터 작은 1 로 가는게 정확 )
 [ 엑셀로 그려보고 규칙 찾음 ]

자료구조
List

시간복잡도
O ( K * N )
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

        int K = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int index = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            for (int i = K; i > 0; i--) {
                if ((index % Math.pow(2, i)) == ((Math.pow(2, i) / 2) - 1)) list.get(i).add(num);
            }

            index++;
        }

        for (int i = K; i > 0; i--) {
            for (int num : list.get(i)) sb.append(num).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
