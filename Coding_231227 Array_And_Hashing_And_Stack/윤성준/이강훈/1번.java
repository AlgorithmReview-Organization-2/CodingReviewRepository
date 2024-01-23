/*
https://www.acmicpc.net/problem/4358

아이디어
Treemap 으로 key 정렬 + 각 문자열 개수 카운트 -> 결과 출력

자료구조
Treemap

시간복잡도
O(N log N) // N = 나무 종류 10000
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> map = new TreeMap<>();

        int totalCount = 0;
        String input = "";
        while ((input = br.readLine()) != null) {
            totalCount++;

            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ");

            double value = (double) entry.getValue() / totalCount;

            sb.append(String.format("%.4f", (double) Math.round(value * 1000000) / 10000)).append("\n");
        }

        System.out.println(sb);
    }
}
