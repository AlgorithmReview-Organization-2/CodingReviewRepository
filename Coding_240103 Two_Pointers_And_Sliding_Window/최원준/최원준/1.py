# https://leetcode.com/problems/boats-to-save-people/description/

'''
1. 아이디어 :
    left와 right 둘다 탈 수 있으면 left +=1, right-=1
    아니면 right +=1
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        boats, left, right = 0, 0, len(people) - 1
        while left <= right:
            if people[right] + people[left] <= limit:
                left += 1
            boats += 1
            right -= 1

        return boats
