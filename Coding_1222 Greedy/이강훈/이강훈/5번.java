/*
https://velog.io/@ahnick/programmers-%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC

아이디어
도착 시간 기준 정렬
 -> 빠른 도착시간 차 꺼내면서 시작시간이 갱신된 도착시간보다 크면 캠이 추가되는 거임
 -> ( 즉, 첫번째 도착차는 그 안에 무조건 카메라 필요, 그 안에 출발한 차들은 모두 패스, 그 이후는 또 카메라 갱신 )

자료구조
배열

시간복잡도
O (N log N)
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int destination = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] > destination) {
                destination = route[1];
                answer++;
            }
        }

        return answer;
    }
}
