/*
https://www.acmicpc.net/problem/7662

아이디어
정렬된 deque 같은 기능을 Treemap 으로 사용

자료구조
Treemap

시간복잡도
O(T * N * log N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int N = Integer.parseInt(br.readLine());

            while (N-- > 0){
                StringTokenizer st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (c == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    Map.Entry<Integer, Integer> entry;
                    if (num == 1){
                        entry = map.lastEntry();

                    } else {
                        entry = map.firstEntry();

                    }
                    if (entry.getValue() > 1) map.put(entry.getKey(), entry.getValue() - 1);
                    else map.remove(entry.getKey());
                }
            }

            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}
