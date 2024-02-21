# https://www.acmicpc.net/problem/1976

'''
1. 아이디어 :
    유니온 파인드를 외우지 못해서 그냥 같은 네트워크에 있는지 확인하는 코드를 짰었다
    그냥 외워야겠다
2. 시간복잡도 :
    O( n**2 )
3. 자료구조 :
    배열
'''

def union(x,y):
    x = find(x)
    y = find(y)
    if x < y:
        parents[y] = x
    else:
        parents[x] = y

def find(x):
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

# 유니온 파인드
n,m = int(input()),int(input())
parents = [i for i in range(n)]
for i in range(n):
    link = list(map(int,input().split()))
    for j in range(n):
        if link[j] == 1:
            union(i,j)

# 경로 체크
parents = [-1] + parents
path = list(map(int,input().split()))
start = parents[path[0]]
for i in range(1,m):
    if parents[path[i]] != start:
        print("NO")
        break
else:
    print("YES")
