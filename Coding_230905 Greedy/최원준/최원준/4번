#https://leetcode.com/problems/gas-station/

'''
1. 아이디어 :
    -1 인 경우를 확인하고,
    left = gas - cost의 배열을 만든다
    left를 순회하면서 0보다 작아지지 않는 idx를 찾는다
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:

        #Check -1
        if sum(gas)<sum(cost):
            return -1

        left = [gas[i]-cost[i] for i in range(len(gas))]
        total = idx = 0
        for i in range(len(left)):
            total += left[i]
            if total < 0:
                total = 0
                idx = float('inf')
            else:
                if i< idx:
                    idx = i
        return idx

