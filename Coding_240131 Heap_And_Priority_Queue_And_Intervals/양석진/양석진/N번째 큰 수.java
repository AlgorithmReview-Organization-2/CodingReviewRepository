import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x = 0; x < n; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y = 0; y < n; y++) {
                int input = Integer.parseInt(st.nextToken());
                // 우선순의 큐의 사이즈를 n으로 제한
                if (pq.size() < n) {
                    pq.add(input);
                } else if (input > pq.peek()) {
                    // 입력 값이 pq의 최소값보다 크면 최소값을 제거 후, 입력
                    // 이러면 pq에는 상위 5개의 숫자가 pq에 담겨져 있음
                    pq.poll();
                    pq.add(input);
                }
            }
        }
        System.out.println(pq.poll());
    }
}