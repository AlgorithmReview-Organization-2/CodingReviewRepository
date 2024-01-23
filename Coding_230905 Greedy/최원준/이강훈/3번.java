/*
https://leetcode.com/problems/jump-game-ii/

아이디어
BFS 썻다가 또 리트코드 다른 코드보고 변경
 -> 최대 점프 인덱스 계산, 도달하면 점프 카운트 증가

자료구조
배열

시간복잡도
O(N)
*/

public class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int maxJumpIndex = 0;
        int maxIndexPerJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndexPerJump = Math.max(maxIndexPerJump, i + nums[i]);

            if (i == maxJumpIndex) {
                jumpCount++;
                maxJumpIndex = maxIndexPerJump;
            }
        }
        return jumpCount;
    }
}
