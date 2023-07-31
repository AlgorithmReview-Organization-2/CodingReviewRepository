# https://www.acmicpc.net/problem/7795

'''
1. 아이디어 :
    B 배열을 정렬하고, A가 B보다 더 커질 때 계산함
2. 시간복잡도 :
    O(n^2)
3. 자료구조 :
    배열
'''

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];
        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            int[] A = new int[N];
            String[] strA = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(strA[j]);
            }

            int[] B = new int[M];
            String[] strB = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(strB[j]);
            }
            Arrays.sort(B);

            // 시작
            for (int j = 0; j < N; j++) {
                for (int k = M - 1; k >= 0; k--) {
                    if (A[j] > B[k]) {
                        answer[i] += k + 1;
                        break;
                    }
                }
            }
            
            bw.write(answer[i] + "\n");
        }

        bw.flush();
    }
}
