/*
https://school.programmers.co.kr/learn/courses/30/lessons/92344

아이디어
2차원 배열 누적합
 -> https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/

자료구조
배열

시간복잡도
O (NM)
*/

public class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] dp = new int[board.length + 1][board[0].length + 1];

        for (int[] nums : skill) {
            int x1 = nums[1];
            int y1 = nums[2];
            int x2 = nums[3];
            int y2 = nums[4];
            int cost = nums[5] * (nums[0] == 1 ? -1 : 1);

            dp[x1][y1] += cost;
            dp[x1][y2 + 1] += (cost * -1);
            dp[x2 + 1][y1] += (cost * -1);
            dp[x2 + 1][y2 + 1] += cost;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                dp[i][j] += dp[i][j-1];
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dp[i][j] += dp[i - 1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + dp[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
