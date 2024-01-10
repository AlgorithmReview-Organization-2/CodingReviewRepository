/*
https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

아이디어
전체 합 - ( 투포인터 구간 합 ) -> 비교
 -> 즉, 투포인터 구간 외 나머지를 합친 개념

자료구조
배열

시간복잡도
O (N)
*/

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = Arrays.stream(nums).sum();

        int answer = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int currnetSum = 0;
        while (r < nums.length) {
            currnetSum += nums[r];

            while (l <= r && totalSum - currnetSum < x)
                currnetSum -= nums[l++];

            if (totalSum - currnetSum == x)
                answer = Math.min(answer, l + (nums.length - (r + 1)));

            r++;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
