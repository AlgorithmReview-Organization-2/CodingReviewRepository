/*
https://www.acmicpc.net/problem/7453

아이디어
AB 합 경우의 수와 CD 합 경우의 수 , 2가지로 구분하고 투포인터

ArrayList 에서 배열로 변경

자료구조
배열

시간복잡도
O ( N^2 log N^2 )
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 두 배열의 합을 저장할 배열
        int[] AB = new int[N * N];
        int[] CD = new int[N * N];

        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[index] = A[i] + B[j];
                CD[index] = C[i] + D[j];
                index++;
            }
        }

        // 정렬
        Arrays.sort(AB);
        Arrays.sort(CD);

        int count = 0;
        int left = 0;
        int right = N * N - 1;

        while (left < N * N && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                int countAB = 1;
                int countCD = 1;

                // AB에서 같은 합을 가진 원소의 개수 세기
                while (left + 1 < N * N && AB[left] == AB[left + 1]) {
                    left++;
                    countAB++;
                }

                // CD에서 같은 합을 가진 원소의 개수 세기
                while (right - 1 >= 0 && CD[right] == CD[right - 1]) {
                    right--;
                    countCD++;
                }

                count += countAB * countCD;
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(count);
    }
}
