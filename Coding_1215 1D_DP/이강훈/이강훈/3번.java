/*
https://school.programmers.co.kr/learn/courses/30/lessons/161988

아이디어
plus, minus 펄수 부분합 1차원 dp
 -> 각 배열 0 to length 까지 가면서 가장 작은 값 저장, 현재 값 - 가장 작은 값 ( 결국 가장 큰 부분합 큰게 가장 큰 부분수열 )

자료구조
배열

시간복잡도
O (N)
*/

public class Solution {
    public long solution(int[] sequence) {
        long[] plusFirst = new long[sequence.length];
        long[] minusFirst = new long[sequence.length];

        plusFirst[0] = sequence[0];
        minusFirst[0] = -sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (i % 2 == 0) {
                plusFirst[i] = plusFirst[i - 1] + sequence[i];
                minusFirst[i] = minusFirst[i - 1] + -sequence[i];
            } else {
                plusFirst[i] = plusFirst[i - 1] + -sequence[i];
                minusFirst[i] = minusFirst[i - 1] + sequence[i];
            }
        }

        long answer = Long.MIN_VALUE;
        long minPlus = 0;
        long minMinus = 0;
        for (int i = 0; i < sequence.length; i++) {
            answer = Math.max(answer, plusFirst[i] + -minPlus);
            answer = Math.max(answer, minusFirst[i] + -minMinus);

            minPlus = Math.min(minPlus, plusFirst[i]);
            minMinus = Math.min(minMinus, minusFirst[i]);
        }

        return answer;
    }
}
