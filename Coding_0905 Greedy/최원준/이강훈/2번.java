/*
https://leetcode.com/problems/jump-game/

아이디어
BFS
 -> 리트코드 딴 사람 코드보고 BFS 필요 없을 거 같아서 리펙터링
  -> 시작 점부터 최대 갈 수 있는 곳 갱신

자료구조
배열

시간복잡도
O(N)
*/

public class Solution {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);

            if (maxIndex >= nums.length - 1) return true;
        }
        return false;
    }
}