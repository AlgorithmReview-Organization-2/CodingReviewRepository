import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Long타입 이유는 파일의 개수가 최대 1,000,000이고 파일의 크기가 9999때문에 Integer 범위에서 벗어난다.

        int test_case = Integer.parseInt(br.readLine());
        while (test_case-- > 0) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int x = 0; x < size; x++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() > 1) {
                long x = pq.poll();
                long y = pq.poll();
                sum += x + y;
                pq.add(x + y);
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}