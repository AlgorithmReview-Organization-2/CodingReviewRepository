# https://leetcode.com/problems/task-scheduler/

'''
1. 아이디어 :
    힙을 사용해서, 빈도가 많은 알파벳을 저장하고 [빈도수, 알파벳], 큐를 사용해서 쿨타임중인 알파벳을 저장한다 [빈도수, 알파벳, 쿨타임]
    힙에서 하나씩 꺼내면서 빈도수가 남아있으면 현재 time+n의 쿨타임과 같이 큐에 저장한다.
2. 시간복잡도 :
    O(n*m)
3. 자료구조 :
    힙, 큐
'''

import heapq
from collections import deque
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        tasks = [[-v,k] for k,v in Counter(tasks).items()]
        heapq.heapify(tasks)
        time = 0
        waits = deque()
        while tasks or waits:
            if tasks:
                task_val, task_key = heapq.heappop(tasks)
                task_val += 1
                if task_val < 0:
                    waits.append([task_key,task_val, time+n])
            if waits and waits[0][2] <= time:
                task_key, task_val, wait_time = waits.popleft()
                heapq.heappush(tasks, [task_val, task_key])
            time+=1
        return time

        print(heapq.heappop(tasks))
        print(tasks)
