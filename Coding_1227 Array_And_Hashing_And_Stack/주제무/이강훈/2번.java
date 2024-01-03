/*
https://school.programmers.co.kr/learn/courses/30/lessons/92334

아이디어
신고 당한 사람 : 신고한 사람 Set 저장 ( 중복 제거 : Set )
 -> 신고한 사람 Set 크기가 k 이상인 경우 각 신고자의 카운트 증가 후 출력

자료구조
HashMap, HashSet

시간복잡도
O (N + M) // N : 신고한 사람 수, M : 신고 당한 사람 수
*/

import java.util.*;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> mailCount = new HashMap<>();
        Map<String, Set<String>> reportUser = new HashMap<>();

        for (String str : report) {
            String reporter = str.split(" ")[0];
            String reported = str.split(" ")[1];

            reportUser.computeIfAbsent(reported, key -> new HashSet<>()).add(reporter);
        }

        for (Map.Entry<String, Set<String>> entry : reportUser.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String reporter : entry.getValue()) {
                    mailCount.put(reporter, mailCount.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        int index = 0;
        for (String id : id_list) {
            answer[index++] = mailCount.getOrDefault(id, 0);
        }

        return answer;
    }
}
