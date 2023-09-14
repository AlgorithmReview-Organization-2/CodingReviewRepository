/*
https://www.acmicpc.net/problem/1049

아이디어
패키지 / 낱개 최소 값 구하고 계산

자료구조
변수

시간복잡도
O(1)
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
        int M = Integer.parseInt(st.nextToken());

        int minPackage = Integer.MAX_VALUE;
        int minPiece = Integer.MAX_VALUE;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
            minPiece = Math.min(minPiece, Integer.parseInt(st.nextToken()));
        }

        int money = 0;
        while (N > 0){
            if (N / 6 >= 1) {
                if ((float) minPackage / 6 < (float) minPiece) {
                    money += minPackage * (N / 6);
                } else {
                    money += minPiece * (N / 6) * 6;
                }
                N %= 6;
            } else {
                if (minPackage < minPiece * N) {
                    money += minPackage;
                } else {
                    money += minPiece * N;
                }
                N = 0;
            }
        }

        System.out.println(money);
    }
}
