/*
https://leetcode.com/problems/house-robber-ii/description/

아이디어 ( 솔루션 보고 품 )
1시작 , 2시작 dp 배열 2개 생성
 -> 1시작은 마지막 집을 사용 못하므로 length - 2 , 2시작은 마지막 집 사용 가능하므로 length - 1 .. 2개 중 큰 값이 정답

자료구조
배열

시간복잡도
O (N)
*/

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 2) return Arrays.stream(nums).max().getAsInt();

        int[] dyFromOne = new int[nums.length];
        int[] dyFromTwo = new int[nums.length];

        dyFromOne[0] = nums[0];
        dyFromOne[1] = nums[0];

        dyFromTwo[0] = 0;
        dyFromTwo[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dyFromOne[i] = Math.max(dyFromOne[i-1], dyFromOne[i-2] + nums[i]);
            dyFromTwo[i] = Math.max(dyFromTwo[i-1], dyFromTwo[i-2] + nums[i]);
        }

        return Math.max(dyFromOne[nums.length - 2], dyFromTwo[nums.length - 1]);
    }
}
