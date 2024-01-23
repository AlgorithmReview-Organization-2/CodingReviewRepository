/*
https://leetcode.com/problems/house-robber/description/

아이디어
1차 DP, 현재 최대 금액 = 자신 + 2개 or 3개 전 금액

자료구조
배열

시간복잡도
O (N)
*/

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 2) return Arrays.stream(nums).max().getAsInt();

        int[] dy = new int[nums.length];

        dy[0] = nums[0];
        dy[1] = nums[1];
        dy[2] = nums[2] + dy[0];

        for (int i = 3; i < dy.length; i++) {
            dy[i] = nums[i] + Math.max(dy[i - 2], dy[i - 3]);
        }

        return Arrays.stream(dy).max().getAsInt();
    }
}
