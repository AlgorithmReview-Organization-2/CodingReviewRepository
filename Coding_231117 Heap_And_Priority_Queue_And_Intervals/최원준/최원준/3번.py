#https://leetcode.com/problems/find-median-from-data-stream/

'''
1. 아이디어 :
    거지같은 문제.
    힙 두개를 사용한다.
    양쪽 힙안에 숫자의 갯수를 1 이하로 차이나도록 골고루 저장한다
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    힙

'''

import heapq
class MedianFinder:

    def __init__(self):
        self.max_heap = []
        self.min_heap = []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.max_heap, -1 * num)

        if (self.max_heap and self.min_heap and ( -1 * self.max_heap[0]) > self.min_heap[0]):
            val = -1 * heapq.heappop(self.max_heap)
            heapq.heappush(self.min_heap, val)

        if len(self.max_heap) > len(self.min_heap) + 1:

            val = -1 * heapq.heappop(self.max_heap)
            heapq.heappush(self.min_heap, val)

        if len(self.min_heap) > len(self.max_heap) + 1:
            val = -1 * heapq.heappop(self.min_heap)
            heapq.heappush(self.max_heap, val)


    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            return -1 * self.max_heap[0]
        if len(self.min_heap) > len(self.max_heap):
            return self.min_heap[0]

        return (-1 * self.max_heap[0] + self.min_heap[0])/2



# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
