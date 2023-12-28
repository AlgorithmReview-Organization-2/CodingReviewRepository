# https://leetcode.com/problems/time-based-key-value-store/

'''
1. 아이디어 :
    순차적으로 들어가기때문에 이분탐색을 이용하여 풀이
2. 시간복잡도 :
    O(logN)
3. 자료구조 :
    해쉬맵
'''

class TimeMap:

    def __init__(self):
        self.hmap = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.hmap:
            self.hmap[key] = []
        self.hmap[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        ans = ""
        if key not in self.hmap:
            return ans
        arr = self.hmap[key]

        left = 0
        right = len(arr)-1
        target = timestamp

        while left <= right:
            mid = (left+right)//2
            if arr[mid][1] <= target:
                ans = arr[mid][0]
                left = mid + 1
            else:
                right = mid - 1
        return ans




# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)
