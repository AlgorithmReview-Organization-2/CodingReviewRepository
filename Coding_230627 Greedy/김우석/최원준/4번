# https://leetcode.com/problems/pancake-sorting/description/

'''
1. 아이디어 :
    최대값을 찾아서 맨 앞으로 보내는 작업을 한 후에, reverse를 통해 맨 뒤로 보낸다.
    최대값을 1개 줄여서 반복한다.
2. 시간복잡도 :
    O(n^2)
    while문과 reversed()가 O(n)이므로, O(n^2)이다.
3. 자료구조 :
    배열
'''


class Solution:
    def pancakeSort(self, A: List[int]) -> List[int]:

        cmax = len(A)
        res = []
        while cmax > 1:
            imax = A.index(cmax)
            if imax == cmax - 1:
                cmax -= 1
                continue

            if imax != 0:
                A[:imax + 1] = reversed(A[:imax + 1])
                res.append(imax + 1)

            A[:cmax] = reversed(A[:cmax])
            res.append(cmax)

            cmax -= 1
        return res
