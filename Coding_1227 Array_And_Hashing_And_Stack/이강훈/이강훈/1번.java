/*
https://school.programmers.co.kr/learn/courses/30/lessons/42577

아이디어
모든 번호 Hash 저장
 -> 모든 번호 가능 접두어 만들며 Hash 존재 여부 체크

자료구조
HashSet

시간복잡도
O (N * Length)
*/

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = Arrays.stream(phone_book).collect(Collectors.toSet());

        for (String phone : phone_book) {
            StringBuilder part = new StringBuilder();

            for (int i = 0; i < phone.length() - 1; i++) {
                part.append(phone.charAt(i));

                if (set.contains(part.toString())) return false;
            }
        }

        return true;
    }
}
