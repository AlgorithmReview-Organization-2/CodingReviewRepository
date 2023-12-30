# https://leetcode.com/problems/hand-of-straights/description/

'''
1. 아이디어 :
    카운터로 각 숫자의 개수를 새고, 힙으로 숫자를 정렬한다.
    힙에서 가장 작은 숫자를 뽑아서, 그 숫자부터 groupSize만큼의 숫자를 카운터에서 빼준다.
    만약 카운터에서 빼준 숫자가 0이면, 해당 숫자를 힙에서 제거한다.
    힙이 비어있으면 True를 반환한다.
    만약 힙이 비어있지 않은데, 카운터에서 빼준 숫자가 0이 아니면 False를 반환한다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    해시맵, 힙
'''

import heapq
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand)%groupSize!=0:
            return False
        c = Counter(hand)
        hand = list(set(hand))
        heapq.heapify(hand)

        while hand:
            start = hand[0]

            for i in range(start, start+groupSize):
                c[i] -=1
                if c[i] < 0:
                    return False

            while c[start] == 0:
                heapq.heappop(hand)

                if not hand:
                    return True

                start = hand[0]

        return True

