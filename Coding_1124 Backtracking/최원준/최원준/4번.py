# https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/

'''
1. 아이디어 :
    백트래킹 문제다.
    num를 내림차순 정렬 후, 배열 [0] * k 를 만들어놓고,
    num를 하나씩 배열에 집어 넣는다.
    i번째 num를 넣을 자리가 없을 경우 다시 되돌아간다.
    주의 할점은 [0,0,0] 배열에서, 첫번째 0에서 연산이 안되었을때는 두번째 0에서도 안되므로,
    break를 걸어줘서 추가 연산을 막는다.
2. 시간복잡도 :
    O(nlogn) + O(k^n) = O(k^n)
3. 자료구조 :
    배열
'''


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if sum(nums) % k:
            return False
        subSets = [0] * k
        nums = sorted(nums, reverse=True)
        target = sum(nums) // k

        def backtrack(i):
            if i == len(nums):
                return True

            for j in range(k):
                print(subSets, nums[i])
                if subSets[j] + nums[i] <= target:
                    subSets[j] += nums[i]

                    if backtrack(i + 1):
                        return True

                    subSets[j] -= nums[i]

                    if subSets[j] == 0:
                        break

        return backtrack(0)
