# https://www.acmicpc.net/problem/9934

'''
1. 아이디어 :
    dfs로 풀 수 있다
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵
'''

k = int(input())
nodes = list(map(int,input().split()))
ans = {}
def dfs(k, arr):
    if not arr:
        return
    mid = len(arr)//2

    if k not in ans:
        ans[k] = []
    ans[k].append(str(arr[mid]))

    dfs(k+1, arr[:mid])
    dfs(k+1, arr[mid+1:])

dfs(0, nodes)
for n in ans:
    print(" ".join(ans[n]))




'''

1 = 1
2 = 2 + 1
3 = 4 + 2 + 1
4 = 8 + 4 + 2 + 1

'''
