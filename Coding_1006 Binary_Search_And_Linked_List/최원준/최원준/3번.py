# https://leetcode.com/problems/median-of-two-sorted-arrays/description/

'''
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조 :

'''

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #작은 배열을 바꾼다.
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        x, y = len(nums1), len(nums2)
        low, high = 0, x

        while low <= high:
            partitionX = (low + high) // 2
            partitionY = (x + y + 1) // 2 - partitionX

            #num1 왼쪽 부분 배열에서 가장 큰 원소
            maxLeftX = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
            #nuum1 오른쪽 부분 배열에서 가장 작은 원소
            minRightX = float('inf') if partitionX == x else nums1[partitionX]

            #num2 왼쪽 부분 배열에서 가장 큰 원소
            maxLeftY = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
            #num2 오른쪽 부분 배열에서 가장 작은 원소
            minRightY = float('inf') if partitionY == y else nums2[partitionY]

            #분할 지점은 중앙값을 찾기에 적절한 위치인지 확인.
            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                if (x + y) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return max(maxLeftX, maxLeftY)
            #아니면 포인터를 옮긴다.
            elif maxLeftX > minRightY:
                high = partitionX - 1
            else:
                low = partitionX + 1
