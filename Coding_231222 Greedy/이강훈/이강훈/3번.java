/*
https://www.acmicpc.net/problem/2812

아이디어
Stack 사용하여 순서대로 넣는데, 최근 넣은 것부터 작으면 제거
 -> N 이 최대 500,000 으로 String 으로 처리해야함

자료구조
Stack

시간복잡도
O(N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            int num = Integer.parseInt(String.valueOf(c));

            while (!deque.isEmpty() && count != M && deque.peekLast() < num){
                deque.removeLast();
                count++;
            }

            deque.addLast(num);
        }

        while (deque.size() > (N - M)) {
            deque.removeLast();
        }

        StringBuilder answer = new StringBuilder();
        while (!deque.isEmpty()) {
            answer.append(deque.removeFirst());
        }

        System.out.println(answer);
    }
}
