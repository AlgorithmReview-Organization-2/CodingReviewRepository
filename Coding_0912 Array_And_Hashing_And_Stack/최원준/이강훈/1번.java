/*
https://leetcode.com/problems/group-anagrams/

아이디어
String 정렬하고 Key 사용 ->  O (M * N log N)
-> 리트코드 다른 사람 풀이보고 변경 -> count 배열을 hash 처럼 key 생성

자료구조
HashMap, 배열

시간복잡도
O(M * N)
*/

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charList = new char[26];

            for (char c : str.toCharArray()){
                charList[c - 97]++;
            }

            String key = String.valueOf(charList);
            map.computeIfAbsent(key, value -> new ArrayList<>()).add(str);
        }

        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            answer.add(entry.getValue());
        }

        return answer;
    }
}