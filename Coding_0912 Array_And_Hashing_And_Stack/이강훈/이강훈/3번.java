/*
https://www.acmicpc.net/problem/17298

아이디어
N^2 으로 접근했지만 시간초과로 아이디어 검색
 -> 앞에서부터 인덱스를 스택에 집어넣음 -> 뒤로 인덱스 갈때마다 오큰수가 가능한지 확인하고 새로운 인덱스 넣음 ( 무조건 스택에 들어가는 수보다 작은 기존 스택 수들은 계싼되어 빠짐 )

자료구조
스택

시간복잡도
O(N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        Stack<Integer> reqIndex = new Stack<>();
        reqIndex.push(0);

        for (int i = 1; i < N; i++) {
            while (!reqIndex.isEmpty()) {
                if (num[i] <= num[reqIndex.peek()]) break;

                answer[reqIndex.pop()] = num[i];
            }

            reqIndex.push(i);
        }

        Arrays.stream(answer).forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);
    }
}
