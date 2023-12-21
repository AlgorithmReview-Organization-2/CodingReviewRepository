/*
https://school.programmers.co.kr/learn/courses/30/lessons/12971

아이디어
1시작, 2시작 DP
 -> 현재 인덱스 계산 값이 이전 인덱스보다 작으면 이전 인덱스 저장 ( 더할 가치가 없으면 )

자료구조
배열

시간복잡도
O (N)
*/

import java.util.Arrays;

public class Solution {
    public int solution(int sticker[]) {
        if (sticker.length <= 2) return Arrays.stream(sticker).max().getAsInt();

        int[] dyFromOne = new int[sticker.length];
        int[] dyFromTwo = new int[sticker.length];

        dyFromOne[0] = sticker[0];
        dyFromOne[1] = sticker[0];

        dyFromTwo[0] = 0;
        dyFromTwo[1] = sticker[1];

        for (int i = 2; i < sticker.length; i++) {
            dyFromOne[i] = Math.max(dyFromOne[i - 1], sticker[i] + dyFromOne[i - 2]);
            dyFromTwo[i] = Math.max(dyFromTwo[i - 1], sticker[i] + dyFromTwo[i - 2]);
        }

        return Math.max(dyFromOne[sticker.length - 2], dyFromTwo[sticker.length - 1]);
    }
}
