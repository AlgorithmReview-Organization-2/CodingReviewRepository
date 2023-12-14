/*
https://school.programmers.co.kr/learn/courses/30/lessons/42897

아이디어
1시작, 2시작 DP
 -> 각 값은 이전 값 or 현재 계산 값 중 큰 것으로 유지
 -> 1시작은 마지막 전 , 2시작은 마지막까지 갈 수 있으므로 둘 중 큰게 정답

자료구조
배열

시간복잡도
O (N)
*/

public class Solution {
    public int solution(int[] money) {
        int[] dyFromOne = new int[money.length];
        int[] dyFromTwo = new int[money.length];

        dyFromOne[0] = money[0];
        dyFromOne[1] = money[0];

        dyFromTwo[0] = 0;
        dyFromTwo[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            dyFromOne[i] = Math.max(dyFromOne[i - 1], money[i] + dyFromOne[i - 2]);
            dyFromTwo[i] = Math.max(dyFromTwo[i - 1], money[i] + dyFromTwo[i - 2]);
        }

        return Math.max(dyFromOne[money.length - 2], dyFromTwo[money.length - 1]);
    }
}
