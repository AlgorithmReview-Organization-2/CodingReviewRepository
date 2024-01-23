/*
https://leetcode.com/problems/maximum-subarray/

아이디어
원준이형 영상 설명 봤는데 맞게 적용한지 모르겠다
index 커지면서 합하고 최대 값 갱신 , 합이 음수 나오면 합한 값 초기화 (정답이 음수일 수 도 있어서 정답 갱신 후 초기화)

자료구조
배열

시간복잡도
O(N)
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int index = 0;
        int total = 0;
        int answer = Integer.MIN_VALUE;

        while (index != nums.length) {
            total += nums[index];

            answer = Math.max(answer, total);
            if (total < 0) total = 0;

            index++;
        }

        return answer;
    }
}