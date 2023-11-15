/*
https://leetcode.com/problems/task-scheduler/

아이디어
n 만큼 다른 것이 사용되야하도록 2개의 큐를 사용
 -> 가장 많은 것이 우선 쓰이는 대기열 pq , 사용한 순으로 저장하는 목록 그냥 큐
  -> 만약 pq 가 비면 대기열이 없으니까 가장 오래된 사용한 task 사용 시간에서 n 만큼 추가 시킴 ( 대기열 없으므로 idle 무조건 발생 )
   -> ( 구현 방법이 안떠올라서 풀이 보면서 했는데 완전 이해는 못함,, 안보고하라하면 못할듯 )

자료구조
pq , 큐

시간복잡도
O ( N log N )
*/

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 대기얄 ( 우선순위 높은 순 )
        Queue<Task> pq = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Task(entry.getKey(), entry.getValue()));
        }

        // 사용해야 하는 대기열 ( 사용한 순 )
        Queue<Task> cooltime = new LinkedList<>();

        int time = 0;
        while (!pq.isEmpty() || !cooltime.isEmpty()) {
            // 모든 대기열 사용했지만 사용해야하는 것이 남은 경우
            if (pq.isEmpty()) {
                time = cooltime.peek().lastUsedTime + n + 1;
            }

            // 사용해야하는 대기열이 다시 추가되는 시간이 된 경우
            if (!cooltime.isEmpty() && time > cooltime.peek().lastUsedTime + n) {
                pq.add(cooltime.poll());
            }

            Task task = pq.poll();
            task.lastUsedTime = time++;
            task.count--;

            if (task.count != 0) cooltime.add(task);
        }

        return time;
    }
}

class Task implements Comparable<Task> {
    char task;
    int count;
    int lastUsedTime;

    public Task(char task, int count) {
        this.task = task;
        this.count = count;
        lastUsedTime = -1;
    }

    @Override
    public int compareTo(Task o) {
        return o.count - this.count;
    }
}
