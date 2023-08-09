# https://www.acmicpc.net/problem/11279

'''
1. 아이디어 :
    우선순위 큐를 알고 있다면 쉽게 품
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append(num)
                            .append("\n");
                } else {
                    sb.append(queue.poll())
                            .append("\n");
                }
            } else {
                queue.offer(num);
            }
        }

        System.out.println(sb);
    }
}
