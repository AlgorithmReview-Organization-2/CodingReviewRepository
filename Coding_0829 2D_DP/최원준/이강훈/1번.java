/*
https://leetcode.com/problems/unique-paths/

아이디어
로봇은 오른쪽, 아래밖에 못 움직임
-> 자신 경우의 수 = 왼쪽, 위의 경우의 수 합
 ( 첫 시작이  1 이 되도록 dp 시작 )

자료구조
2차원 배열

시간복잡도
O(m * n)
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dy = new int[m + 1][n + 1];
        dy[0][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dy[j][i] = dy[j - 1][i] + dy[j][i - 1];
            }
        }

        return dy[m][n];
    }
}