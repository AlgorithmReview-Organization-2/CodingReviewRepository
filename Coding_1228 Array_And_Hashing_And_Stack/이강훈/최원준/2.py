# https://school.programmers.co.kr/learn/courses/30/lessons/42583

'''
1. 아이디어 :
    순차적이기 때문에 쉽게 풀 수 있다.
    큐를 사용
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    큐
'''

from collections import deque
def solution(bridge_length, weight, truck_weights):
    truck_weights = truck_weights[::-1]

    bridge = deque([0] * bridge_length)
    narrived = len(truck_weights)
    total_weight = 0
    time = 0

    while narrived:
        if bridge[0] != 0:
            narrived -= 1
        total_weight -= bridge.popleft()
        if truck_weights and total_weight + truck_weights[-1] <= weight:
            truck = truck_weights.pop()
            bridge.append(truck)
            total_weight+=truck
        else:
            bridge.append(0)
        time+=1


    return time


