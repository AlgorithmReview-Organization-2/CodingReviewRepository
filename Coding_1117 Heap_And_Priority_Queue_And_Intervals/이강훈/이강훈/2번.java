/*
https://www.acmicpc.net/problem/1715

아이디어
작은 두 수 뺴서 더한 값 pq 에 추가 및 결과에 더한 비용 추가 반복
 -> 한 수만 남을 때 까지 반복

자료구조
최소 힙

시간복잡도
O ( N log N )
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int value = 0;
        while (!pq.isEmpty()) {
            int num1 = pq.poll();
            int num2 = pq.size() == 0 ? 0 : pq.poll();

            if (num2 != 0) {
                pq.add(num1 + num2);
                value += num1 + num2;
            } else {
                break;
            }
        }

        System.out.println(value);
    }
}
