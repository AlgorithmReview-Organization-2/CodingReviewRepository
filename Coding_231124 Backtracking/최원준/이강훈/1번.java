/*
https://leetcode.com/problems/find-unique-binary-string/description/

1. 아이디어
구현

2. 자료구조
배열

3. 시간 복잡도
O(N)
*/

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
        }
        return new String(sb);
    }
}