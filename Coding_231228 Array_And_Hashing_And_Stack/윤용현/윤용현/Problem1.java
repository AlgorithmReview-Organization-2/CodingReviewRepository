package array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/longest-consecutive-sequence/description
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int mx = 0;
        for (int n : nums) {
            int len = 1;
            int st = n;

            if (!numbers.contains(n - 1)) {
                while (numbers.contains(st + 1)) {
                    len++;
                    st++;
                }

            }

            if (len > mx) {
                mx = len;
            }
        }

        return mx;
    }
}
