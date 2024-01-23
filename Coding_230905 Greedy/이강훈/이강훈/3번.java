/*
https://www.acmicpc.net/problem/1141

아이디어
정렬 & 트라이
-> 짧은 길이 문자열부터 트라이 만들고, 마지막 문자열 못찾으면 그게 마지막이니까 카운트, 찾으면 마지막 노드 갱신 ( 그룹이므로 ) 후 카운트는 안함

자료구조
트라이

시간복잡도
O(N * M) -> N = 문자 수 , M = 문자 길이 -> 최악 O (50*50)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        while (N-- > 0) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int prefixCount = 0;
        Node root = new Node();
        for (String str : list) {
            if (!insertAndFindTries(str, root)) prefixCount++;
        }

        System.out.println(prefixCount);
    }

    public static boolean insertAndFindTries(String str, Node node) {
        boolean findLast = false;

        for (char c : str.toCharArray()) {
            node = node.map.computeIfAbsent(c, key -> new Node());

            if (node.isLast){
                findLast = true;
                node.isLast = false;
            }
        }

        node.isLast = true;
        return findLast;
    }
}

class Node {
    Map<Character, Node> map = new HashMap<>();
    boolean isLast;
}
