# https://leetcode.com/problems/maximum-tastiness-of-candy-basket/

'''
1. 아이디어 :
    정렬 후, maximuum tastiness를 정하고, candies가 k를 넘는지 확인한다.
    maximum tastiness를 이분탐색으로 찾으면서, canies가 k보다 같거나 같으면 tastiness를 낮추고, candies가 k를 넘으면 tastiness를 높인다.
2. 시간복잡도 :
    O(NlogN)
3. 자료구조 :
    배열
'''

class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()

        ans = -1
        low= 0
        high = price[-1] - price[0]

        while low<=high:
            mid=(low+high)//2
            i=1
            candies=1
            j=0
            while i < len(price):
                if price[i]-price[j] >= mid:
                    candies+=1
                    j=i
                i+=1
            if candies >= k:
                ans=mid
                low=mid+1
            else:
                high=mid-1
        return ans
