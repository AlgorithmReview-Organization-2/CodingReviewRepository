/*
https://www.acmicpc.net/problem/23309

아이디어
링크드리스트 - index 가져오는 메서드가 O(N) 이 걸려서 시간 초과 예상
 -> HashMap 으로 링크드 리스트 구현
 -> 안됨.. 반례를 모르겠음

자료구조
HashMap

시간복잡도
O(M)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, NodeInfo> map = new HashMap<>();

        if (N != 1) {
            for (int i = 0; i < N; i++) {
                if (i == 0) {
                    map.put(nums[i], new NodeInfo(nums[N - 1], nums[i + 1]));
                } else if (i == N - 1) {
                    map.put(nums[i], new NodeInfo(nums[N - 2], nums[0]));
                } else {
                    map.put(nums[i], new NodeInfo(nums[i - 1], nums[i + 1]));
                }
            }
        } else {
            map.put(nums[0], null);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int index = Integer.parseInt(st.nextToken());
            if (cmd.equals("BN")) {
                int newIndex = Integer.parseInt(st.nextToken());
                int currentNextIndex = map.get(index).nextIndex;

                sb.append(currentNextIndex).append("\n");

                map.get(currentNextIndex).beforeIndex = newIndex;
                map.put(newIndex, new NodeInfo(index, currentNextIndex));
                map.get(index).nextIndex = newIndex;
            } else if (cmd.equals("BP")) {
                int newIndex = Integer.parseInt(st.nextToken());
                int currentBeforeIndex = map.get(index).beforeIndex;

                sb.append(currentBeforeIndex).append("\n");

                map.get(index).beforeIndex = newIndex;
                map.put(newIndex, new NodeInfo(currentBeforeIndex, index));
                map.get(currentBeforeIndex).nextIndex = newIndex;
            } else if (cmd.equals("CN")) {
                int currentNextIndex = map.get(index).nextIndex;


                sb.append(currentNextIndex).append("\n");

                map.get(map.get(currentNextIndex).nextIndex).beforeIndex = index;
                map.get(index).nextIndex = map.get(currentNextIndex).nextIndex;
                map.remove(currentNextIndex);
            } else if (cmd.equals("CP")) {
                int currentBeforeIndex = map.get(index).beforeIndex;

                sb.append(currentBeforeIndex).append("\n");

                map.get(index).beforeIndex = map.get(currentBeforeIndex).beforeIndex;
                map.get(map.get(currentBeforeIndex).beforeIndex).nextIndex = index;
                map.remove(currentBeforeIndex);
            }
        }

        System.out.println(sb);
    }
}

class NodeInfo {
    int beforeIndex;
    int nextIndex;

    public NodeInfo(int beforeIndex, int nextIndex) {
        this.beforeIndex = beforeIndex;
        this.nextIndex = nextIndex;
    }
}