/*
https://www.acmicpc.net/submit/1927

아이디어
오름차순 PQ

자료구조
오름차순 PQ

시간복잡도
O(n log n)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int popNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue priorityQueue = new PriorityQueue();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == popNum) {
                if (!priorityQueue.isEmpty()) sb.append(priorityQueue.poll()).append("\n");
                else sb.append("0\n");
            } else {
                priorityQueue.add(num);
            }
        }
        System.out.println(sb);
    }
}
