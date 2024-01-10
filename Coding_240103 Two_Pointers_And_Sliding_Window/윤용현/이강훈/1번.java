/*
https://leetcode.com/problems/container-with-most-water/description/

아이디어
투 포인터, 좌/우 중 낮은 곳 이동 , 같으면 동시 이동

자료구조
배열

시간복잡도
O(N)
*/

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while (left <= right) {
            answer = Math.max(answer, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }

        return answer;
    }
}
