/*
https://school.programmers.co.kr/learn/courses/30/lessons/42583

아이디어
큐 -> 다리 길이 유지
 시간 증가하며 큐에서 항상 제거 -> 만약 트럭이면 카운트 증가 후 다음 트럭 출발 여부 판단

자료구조
큐

시간복잡도
O ( Truck N * 다리 길이 M )
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int totalCount = truck_weights.length;
        int completeCount = 0;
        int currentWeight = 0;
        int truckIndex = 0;

        while (completeCount < totalCount) {
            answer++;
            int num = queue.poll();

            // 빈 값인 0 이 아닌 트럭이 나온 경우
            if (num != 0) {
                completeCount++;

                currentWeight -= num;

                if (completeCount == totalCount) break;
            }

            // 새로운 트럭이 추가될 수 있는 경우
            if (truckIndex < totalCount && currentWeight + truck_weights[truckIndex] <= weight) {
                queue.add(truck_weights[truckIndex]);

                currentWeight += truck_weights[truckIndex++];
            }
            // 추가 불가능한 경우
            else {
                queue.add(0);
            }
        }

        return answer;
    }
}
