'''
https://www.acmicpc.net/problem/1135

주제: 트리, dp

구현
top-down 방식의 dp
입력에서 자식을 저장하는 트리형태로 전환
'''
def dp(cur):
    if not tree[cur]:
        return 0

    tmp = []
    for child in tree[cur]:
        tmp.append(dp(child)+1)
    tmp.sort(reverse=True)

    tmp = [i+v for i, v in enumerate(tmp)]
    node_count[cur] = max(tmp)
    return node_count[cur]


N = int(input())
arr = list(map(int, input().split()))

tree = [[] for _ in range(N)]
for child, parent in enumerate(arr[1:], start=1):
    tree[parent].append(child)

node_count = [0]*N
dp(0)
print(node_count[0])
