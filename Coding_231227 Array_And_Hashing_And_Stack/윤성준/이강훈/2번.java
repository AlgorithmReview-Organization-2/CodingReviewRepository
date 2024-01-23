/*
https://www.acmicpc.net/problem/2800

아이디어
S -> T 가 아닌 T -> S 로 정답 도출 ( 갈림길 없이 진행하기 위해 )

자료구조
문자열

시간복잡도
O (T)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while (S.length() != T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(T.substring(0, T.length() - 1)).reverse();

                T = sb.toString();
            }
        }

        System.out.println(S.equals(T) ? 1 : 0);
    }
}
