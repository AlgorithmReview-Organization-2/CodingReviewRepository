/*
https://school.programmers.co.kr/learn/courses/30/lessons/12952

1. 아이디어
각 행마다 퀸 열 위치 기록
 -> 행이 증가 (아래로) 될때마다 이전 (위) 행들의 퀸 위치 (열) 을 검사

2. 자료구조
배열

3. 시간 복잡도
O(N!)
*/

public class Solution {
    int[] used;

    int answer;

    public int solution(int n) {
        used = new int[n];

        backtrack(0, n);

        return answer;
    }

    public void backtrack(int depth, int n) {
        if (depth == n) {
            answer++;

            return;
        }

        // 현재 행 ( depth ) 에서 사용할 열 선택
        mainloop:
        for (int i = 0; i < n; i++) {
            used[depth] = i;

            // 이전 행 체크
            for (int j = 0; j < i; j++) {
                // 조건 1. 같은 열 체크
                if (used[depth] == used[j]) continue mainloop;

                // 조건 2. 대각 체크
                if (Math.abs(depth - j) == Math.abs(used[depth] - used[j])) continue mainloop;
            }

            backtrack(depth + 1, n);
        }
    }
}