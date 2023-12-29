/*
https://leetcode.com/problems/valid-parenthesis-string/

아이디어
각 문자 수 카운트

자료구조
변수

시간복잡도
O(N)
*/

public class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == '*'){
                min--;
                max++;
            } else if (c == '(') {
                min++;
                max++;
            } else {
                min--;
                max--;
            }

            if (max < 0) return false;

            min = Math.max(min, 0);
        }

        return min == 0;
    }
}
