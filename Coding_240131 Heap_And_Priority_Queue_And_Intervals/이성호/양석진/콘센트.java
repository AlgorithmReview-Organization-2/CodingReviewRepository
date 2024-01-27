import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int socketN = Integer.parseInt(st.nextToken());
        int[] socket = new int[socketN];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < n; x++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        int time = 0;

        while (!pq.isEmpty()) {
            for (int x = 0; x < socketN; x++) {
                if (socket[x] == 0 && !pq.isEmpty()) {
                    socket[x] = pq.poll();
                }
            }
            // 1. 가장 작거나 같은 숫자를 각 배열에서 뺀다. (가장 작은 숫자는 마지막 숫자)
            // 2. 뻄과 동시에 time에 더해준다.
            time += socket[socketN - 1];
            for (int x = 0; x < socketN; x++) {
                socket[x] -= socket[socketN - 1];
            }
            // 3. 비어있는 배열에 다음 queue를 넣어준다.
        }

        // 4. 큐는 비어있는데 배열의 숫자가 처리되지 않은 경우 -> 가장 큰 수만 시간에 더해준다.
        time += socket[0];

        System.out.println(time);
    }
}