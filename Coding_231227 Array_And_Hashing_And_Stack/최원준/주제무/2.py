'''
https://leetcode.com/problems/maximum-frequency-stack/

주제: 스택
시간복잡도: nlogn

구현
해쉬를 사용해서 value 카운트를 저장
frequency와 index를 기준으로 max heap 저장
'''
import heapq


class FreqStack:

    def __init__(self):
        self.values = []
        self.value2count = {}
        self.cur_index = 0

    def push(self, val: int) -> None:
        if val not in self.value2count:
            self.value2count[val] = 0

        self.value2count[val] += 1
        heapq.heappush(self.values, (-self.value2count[val], -self.cur_index, val))
        self.cur_index += 1

    def pop(self) -> int:
        val = heapq.heappop(self.values)[2]
        self.value2count[val] -= 1
        return val
