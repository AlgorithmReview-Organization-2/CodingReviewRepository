/*
https://school.programmers.co.kr/learn/courses/30/lessons/43105

아이디어
2차 DP

자료구조
배열

시간복잡도
O(N)
*/

import java.util.Arrays;

public class Solution {
    public int solution(int[][] triangle) {
        int[][] dy = new int[triangle.length][triangle[triangle.length - 1].length];
        dy[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                int current = triangle[i][j];

                if (j == 0) {
                    dy[i][j] = current + dy[i-1][j];
                } else if (j == i) {
                    dy[i][j] = current + dy[i-1][j-1];
                } else {
                    dy[i][j] = current + Math.max(dy[i-1][j], dy[i-1][j-1]);
                }
            }
        }

        return Arrays.stream(dy[triangle.length-1]).max().getAsInt();
    }
}
