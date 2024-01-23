# https://www.acmicpc.net/problem/9372

'''
1. 아이디어 :
    최소 신장 트리의 성질을 이용하면 쉬움
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    
'''

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(N - 1);

            for (int j = 0; j < M; j++) {
                sc.nextLine();
            }
        }
    }
}
