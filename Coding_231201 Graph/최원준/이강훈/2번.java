/*
https://leetcode.com/problems/rotting-oranges/submissions/1112691834/

아이디어
BFS

자료구조
큐

시간복잡도
O (N * M)
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[][] pos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int answer = 0;

        int normalOrange = 0;
        int changeOrange = 0;

        Queue<Orange> queue = new LinkedList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 2) queue.add(new Orange(y, x, 0));
                else if (grid[y][x] == 1) normalOrange++;
            }
        }

        while (!queue.isEmpty()) {
            Orange orange = queue.poll();

            answer = orange.time;

            for (int i = 0; i < 4; i++) {
                int newy = orange.y + pos[i][0];
                int newx = orange.x + pos[i][1];

                if (newy >= grid.length || newy < 0 || newx >= grid[0].length || newx < 0) continue;
                if (grid[newy][newx] != 1) continue;

                queue.add(new Orange(newy, newx, orange.time + 1));
                grid[newy][newx] = 2;
                changeOrange++;
            }
        }

        return changeOrange == normalOrange ? answer : -1;
    }
}

class Orange {
    int y;
    int x;
    int time;

    public Orange(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}
