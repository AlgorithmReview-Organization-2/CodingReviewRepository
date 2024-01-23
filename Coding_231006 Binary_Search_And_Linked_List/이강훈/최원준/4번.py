# https://www.acmicpc.net/problem/12015

'''
1. 아이디어 :
    1. dp로 풀 수 있다
    2. 이분탐색으로 풀 수 있다.
       새로운 작은 배열이 올때마다, 새롭게 배열을 만들어야하는데, 이렇게되면 배열이 무수히 많아지므로,
       기존 배열에 숫자를 넣어서 카운팅을 하면 된다.
2. 시간복잡도 :
    1. O(n^2)
    2. O(nlogn)
3. 자료구조 :
    1. 배열
    2. 배열
'''

'''
n = int(input())
nums = list(map(int, input().split()))

dp = [1] * n

for i in range(n - 1, -1, -1):
    for j in range(i+1, n):
        if nums[i] < nums[j]:
            dp[i] = max(dp[i], 1+dp[j])
print(max(dp))
'''

n = int(input())
nums = list(map(int, input().split()))


def binary_search(arr, target):
    if not arr:
        return [target]
    if target > arr[-1]:
        arr.append(target)
        return arr
    if target == arr[-1]:
        return arr
    left = 0
    right = len(arr)
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] < target:
            left = mid + 1
        elif arr[mid] > target:
            right = mid - 1
        elif arr[mid] == target:
            return arr
    arr[left] = target
    return arr


dp = []
for n in nums:
    dp = binary_search(dp, n)
print(len(dp))
