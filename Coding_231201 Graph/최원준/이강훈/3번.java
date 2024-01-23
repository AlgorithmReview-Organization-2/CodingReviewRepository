/*
https://leetcode.com/problems/snakes-and-ladders/

아이디어

자료구조

시간복잡도

*/

import java.util.stream.IntStream;

public class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] board;
    boolean[][] visited;

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        visited = new boolean[board.length][board.length];

        int index = 0;
        for (int i = board.length - 1; i >= 0; i--) {
            if (index % 2 == 1) {
                int[] nums = board[i];
                board[i] = IntStream.rangeClosed(1, board[i].length).mapToObj(j -> nums[board[0].length - j]).mapToInt(k -> k).toArray();
            }

            index++;
        }

        dfs(board.length - 1, 0, 0);

        return answer;
    }

    public void dfs(int y, int x, int count) {
        // 도착 검사
        if (y == 0 && x == board.length - 1) answer = Math.min(answer, count);
            // 이미 기존 경우보다 비효율 적인 경우
        else if (count >= answer) return;

        // 주사위 6까지 계산
        for (int i = 1; i < 7; i++) {
            int[] newPos = calculate(y, x, i);
            int newy = newPos[0];
            int newx = newPos[1];

            if (visited[newy][newx]) continue;
            // 주사위 5까지 -1은 굴릴 필요 없음
            if (i != 6 && board[newy][newx] == -1) continue;

            // 마지막 도착인 경우
            if (newy < 0) dfs(0, board.length - 1, count + 1);
            else {
                // 도착지가 사다리나 뱀이면 갱신 필요
                int[] newnewPos = calculate(newy, newx, board[newy][newx]);
                int newnewy = newnewPos[0];
                int newnewx = newnewPos[1];

                // 뱀 사용 중복 방지
                visited[newy][newx] = true;
                visited[newnewy][newnewx] = true;
                dfs(newy, newx, count + 1);
                visited[newy][newx] = false;
                visited[newnewy][newnewx] = false;
            }
        }
    }

    public int[] calculate(int y, int x, int distance) {
        if (distance == -1) return new int[]{y, x};

        int newx = x + distance;
        int newy = y;
        while (newx >= board.length) {
            y--;
            newx %= board.length;
        }

        return new int[]{newy, newx};
    }
}
