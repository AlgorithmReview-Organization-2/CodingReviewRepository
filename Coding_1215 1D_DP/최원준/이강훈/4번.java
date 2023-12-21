/*
https://leetcode.com/problems/palindromic-substrings/submissions/

아이디어
3번 팰린드롬 문제의 간단 버전
 -> DP 저장, 팰린드롬 조건 일치 시 정답 수 증가

자료구조
2차원 배열

시간복잡도
O (N^2)
*/

public class Solution {
    public int countSubstrings(String s) {
        boolean[][] dy = new boolean[s.length()][s.length()];

        int maxLength = Integer.MIN_VALUE;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            dy[i][i] = true;
            answer++;

            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dy[j + 1][i - 1])) {
                    dy[j][i] = true;
                    answer++;
                }
            }
        }

        return answer;
    }
}
