import sys
sys.setrecursionlimit(10**6)# 재귀함수 깊이 설정

N = int(input())# 노드의 개수

S = list(map(int,input().split()))# 부모 노드의 번호

graph = [[] for _ in range(N)]# 그래프
visited = [False] *(N)# 방문 여부
dp = [0] *(N)# DP값

for i in range(N):# 그래프 생성
    if i==0:# 루트노드면
        continue# 루트노드는 제외
    graph[i].append(S[i])# 부모노드 추가
    graph[S[i]].append(i)# 자식노드 추가


def dfs(x):# DFS
    visited[x]=True# 방문처리
    elem = [] # DP값을 담을 리스트
    for i in graph[x]:# 자식노드 탐색
        if not visited[i]:# 방문하지 않았으면
            dfs(i)# DFS
            elem.append(dp[i])# DP값 추가
    if not elem: # 리프노드면 끝냄
        return# 끝냄
    elem.sort(reverse=True)# DP값을 내림차순으로 정렬
    max_num = 0# 최대값
    for i in range(len(elem)):# DP값을 더함
        check = elem[i] + (i+1)# DP값 + 자식노드의 개수
        if check>max_num:# 최대값보다 크면
            max_num=check# 최대값 갱신

    dp[x] = max_num# DP값 갱신

dfs(0)# DFS
print(max(dp))# 최대값 출력