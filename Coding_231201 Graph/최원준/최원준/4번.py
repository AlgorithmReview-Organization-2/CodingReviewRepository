# https://leetcode.com/problems/open-the-lock/

'''
1. 아이디어 :
    최소 횟수가 나와야하기 떄문에 bfs로 푼다.
    큐에 '0000'과 0(카운트)를 시작으로,
    0000에서 나올 수 있는 모든 조합을 다시 큐에 넣는다.
    0000은 이미 방문했고 답이 아니므로 visited에 넣어준다.
    deadends도 답이 아니므로 visited에 함꼐 넣어준다.
2. 시간복잡도 :
    O(10**4)
3. 자료구조 :
    큐
'''

from collections import deque


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1

        def children(lock):
            candid = []
            for i in range(4):
                digit = str((int(lock[i]) + 1) % 10)
                candid.append(lock[:i] + digit + lock[i + 1:])
                digit = str((int(lock[i]) - 1 + 10) % 10)
                candid.append(lock[:i] + digit + lock[i + 1:])
            return candid

        q = deque()
        q.append(["0000", 0])
        visited = set(deadends)

        while q:
            lock, turns = q.popleft()
            if lock == target:
                return turns

            for child in children(lock):
                if child not in visited:
                    visited.add(child)
                    q.append([child, turns + 1])

        return -1
