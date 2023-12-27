/*
https://leetcode.com/problems/merge-triplets-to-form-target-triplet/

아이디어
완전탐색 - 타겟보다 큰 수가 있는 triplet 은 무시

자료구조
배열

시간복잡도
O(N * 3)
*/

import java.util.Arrays;

public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] max = new int[]{0, 0, 0};

        triplet:
        for (int[] triplet : triplets){
            int[] temp = Arrays.copyOf(max, max.length);

            int index = 0;
            for (int n : triplet){
                if (n > target[index]) continue triplet;

                temp[index] = Math.max(temp[index], n);
                index++;
            }

            max = temp;
        }

        for (int i = 0; i < 3; i++) {
            if (max[i] != target[i]) return false;
        }

        return true;
    }
}