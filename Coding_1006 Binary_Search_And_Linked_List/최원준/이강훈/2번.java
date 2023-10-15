/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

아이디어
1. [m] 이 좌측 , 우측 그룹 중 어디에 속하는지 찾기
1-1. 우측 그룹이면 target 이 [r] 보다 크면 정답은 좌측 그룹, 작다면 정답은 우측 그룹
 2. 우측 그룹이더라도 m 보다 좌측인지 우측인지 판단
1-2. 좌측 그룹이면 target 이 [l] 보다 작으면 정답은 우측 그룹, 크다면 정답은 좌측 그룹
 2. 좌측 그룹이더라도 m 보다 좌측인지 우측인지 판단
-> 쭉 이분탐색

자료구조
배열

시간복잡도
O (log N)
*/

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;

            if (nums[m] < nums[r]) {
                if (target > nums[r]) r = m - 1;
                else {
                    if (target <= nums[m]) r = m - 1;
                    else l = m + 1;
                }
            } else {
                if (target < nums[l]) l = m + 1;
                else {
                    if ( target <= nums[m]) r = m - 1;
                    else l = m + 1;
                }
            }
        }

        return -1;
    }
}
