/*
https://school.programmers.co.kr/learn/courses/30/lessons/12907

아이디어
1차 DP
 -> 돈 하나 씩 최대 사용 금액까지 DP , 현재 금액 가능성에 돈 뺀 가능성 추가
  -> ex, 2 -> 2+5 -> 2+5+5

자료구조
배열

시간복잡도
O ( N * M ) // N = n, M = 돈 수량
*/

public class Solution {
    public int solution(int n, int[] money) {
        int[] dy = new int[n + 1];
        dy[0] = 1;

        for (int num : money) {
            for (int i = num; i <= n; i++) {
                dy[i] += dy[i - num];
            }
        }

        return dy[n];
    }
}
