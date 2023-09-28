# https://leetcode.com/problems/top-k-frequent-elements/description/

'''
1. 아이디어 :
    Counter를 이용해서 각 숫자들의 빈도수를 구하고, 그 빈도수를 기준으로 내림차순 정렬한다.
    k만큼 뽑아낸다
2. 시간복잡도 :
    O(n) + O(nlogn) + O(k) = O(nlogn)
3. 자료구조 :
    해시맵
'''

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums)
        nums = sorted([[v,k] for k,v in c.items()], reverse=True)
        return [v for k,v in nums][:k]
