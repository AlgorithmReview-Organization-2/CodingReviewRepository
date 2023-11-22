/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/

1. 아이디어
백트래킹 구현

2. 자료구조
배열

3. 시간 복잡도
O(2^N)
*/

import java.util.List;

public class Solution {
    int max = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, "", 0);

        return max;
    }

    private void backtrack(List<String> arr, String current, int start) {
        if (max < current.length()) max = current.length();

        for (int i = start; i < arr.size(); i++) {
            if (!isValid(current, arr.get(i))) continue;

            backtrack(arr, current + arr.get(i), i + 1);
        }
    }

    private boolean isValid(String orgString, String newString) {
        int[] array = new int[26];

        for (int i = 0; i < newString.length(); i++) {
            if (++array[newString.charAt(i) - 'a'] == 2) return false;
            if (orgString.contains(String.valueOf(newString.charAt(i)))) return false;
        }

        return true;
    }
}