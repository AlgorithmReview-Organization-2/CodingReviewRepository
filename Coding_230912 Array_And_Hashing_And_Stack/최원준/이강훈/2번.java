/*
https://leetcode.com/problems/top-k-frequent-elements/description/

아이디어
각 숫자 카운트 후 정렬 후 출력

자료구조
HashMap, Priority Queue

시간복잡도
O(N log N)
*/

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count - o1.count;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = pq.poll().num;
        }

        return answer;
    }
}

class Node {
    int num;
    int count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}