/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

아이디어
이분탐색
-> r 이 m 보다 작으면 중간까지 큰 수들이 로테이션 된거니까 l 을 m + 1 로, 아니면 r 을 m 으로 옮김
--
7123456
l  m  r
lm r
--

자료구조
배열

시간복잡도
O ( log N )
*/

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int answer = Integer.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;
            answer = Math.min(answer, nums[m]);

            if (nums[m] >= nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return answer;
    }
}
