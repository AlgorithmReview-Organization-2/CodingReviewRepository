# https://www.acmicpc.net/problem/14244

'''
1. 아이디어 :
    검색해서 문제 설명봤습니다..
    보여주는 예제가 잘못된거 같음
2. 시간복잡도 :
    O(n)
3. 자료구조 :

'''

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int leaf = m == 2 ? 1 : 0;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            if (m <= leaf++) System.out.println(temp + " " + i);
            else System.out.println(0 + " " + i);

            temp = i;
        }
    }
}
