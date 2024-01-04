/*
https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150

아이디어
Set 목록 저장
 -> 특정 값부터 왼쪽, 오른쪽 최대한 이동하면서 Set 에서 제거

자료구조
HashSet

시간복잡도
O (N)
*/

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            if (set.contains(num)) {
                int count = 1;
                set.remove(num);

                for (int i = 1; true; i++) {
                    if (set.contains(num - i)) {
                        count++;
                        set.remove(num - i);
                    } else break;
                }

                for (int i = 1; true; i++) {
                    if (set.contains(num + i)) {
                        count++;
                        set.remove(num + i);
                    } else break;
                }

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}
