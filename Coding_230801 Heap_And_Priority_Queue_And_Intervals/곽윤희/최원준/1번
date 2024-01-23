# https://leetcode.com/problems/take-gifts-from-the-richest-pile/

'''
1. 아이디어 :
    gifts를 최대힙으로 만든다.
    하나씩 꺼내면서 제곱근 추가.
2. 시간복잡도 :
    O(NlogN)
3. 자료구조 :
    최대힙
'''



import heapq
class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        for i in range(len(gifts)):
            gifts[i]*=-1
        heapq.heapify(gifts)

        for i in range(k):
            temp=heapq.heappop(gifts)
            temp=-int((-temp)**0.5)
            heapq.heappush(gifts,temp)

        return -sum(gifts)
