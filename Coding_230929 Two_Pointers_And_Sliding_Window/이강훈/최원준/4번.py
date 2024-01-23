# https://www.acmicpc.net/problem/7453

'''
1. 아이디어 :
    4 sum 문제다. AB를 더하고 CD가 존재하는지 확인
2. 시간복잡도 :
    O(n**2)
3. 자료구조 :
    배열, 해시맵
'''

n = int(input())
nums = []
AB = []
CD = {}
for i in range(n):
    nums.append(list(map(int, input().split())))

for i in range(len(nums)):
    for j in range(len(nums)):
        AB.append(nums[i][0] + nums[j][1])
        temp = -(nums[i][2] + nums[j][3])
        CD[temp] = CD.get(temp, 0) + 1

ans = 0
for n in AB:
    ans += CD.get(n, 0)
print(ans)
