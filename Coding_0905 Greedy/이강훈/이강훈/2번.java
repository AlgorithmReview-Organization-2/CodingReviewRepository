/*
https://www.acmicpc.net/problem/1213

아이디어
알파벳 순서 출력 -> TreeMap 카운트

자료구조
TreeMap

시간복잡도
O(N log N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int oddCount = 0;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (char c : str.toCharArray()) {
            treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
        }

        char middleChar = 0;
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                middleChar = entry.getKey();

                if (++oddCount > 1) break;
            }

            for (int i = 0; i < entry.getValue() / 2; i++) {
                sb.append(entry.getKey());
            }
            entry.setValue(entry.getValue() / 2);

        }

        if (middleChar != 0) sb.append(middleChar);

        while (!treeMap.isEmpty()) {
            Map.Entry<Character, Integer> entry = treeMap.pollLastEntry();

            for (int j = 0; j < entry.getValue(); j++) {
                sb.append(entry.getKey());
            }
        }

        System.out.println(oddCount > 1 ? "I'm Sorry Hansoo" : sb);
    }
}
