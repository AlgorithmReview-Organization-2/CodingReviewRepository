/*
https://leetcode.com/problems/boats-to-save-people/description/

아이디어
정렬, 투포인터

자료구조
배열

시간복잡도
O (N log N)
*/

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        while (left <= right) {
            if (people[left] + people[right--] <= limit) {
                left++;
            }

            answer++;
        }

        return answer;
    }
}
