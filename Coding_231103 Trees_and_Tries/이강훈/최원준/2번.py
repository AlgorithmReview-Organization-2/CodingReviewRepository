import sys
sys.setrecursionlimit(10**9)
nums = []
while True:
    try:
        nums.append(int(sys.stdin.readline()))
    except:
        break
def dfs(start, end):
    if start > end:
        return
    base = nums[start]
    mid = end+1
    for i in range(start+1, end+1):
        if base < nums[i]:
            mid = i
            break

    dfs(start+1, mid-1)
    dfs(mid, end)
    print(base)

dfs(0, len(nums)-1)
