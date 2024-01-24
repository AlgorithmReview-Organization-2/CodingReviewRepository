import sys#빠른 입력을 위한 모듈
input = sys.stdin.readline#빠른 입력을 위한 함수

def dfs(num, arr):#깊이 우선 탐색
    """
    깊이 우선 탐색을 수행하는 함수입니다.

    Parameters:
        num (int): 탐색을 시작할 노드의 인덱스
        arr (list): 노드들의 연결 정보를 담은 리스트

    Returns:
        None
    """
    arr[num] = -2#방문한 노드는 -2로 바꿔줌
    for i in range(len(arr)):#노드들을 탐색
        if num == arr[i]:#노드가 연결되어 있으면
            dfs(i, arr)#깊이 우선 탐색

n = int(input())#노드의 개수
arr = list(map(int, input().split()))#노드들의 연결 정보를 담은 리스트
k = int(input())#삭제할 노드의 인덱스
count = 0

dfs(k, arr)#깊이 우선 탐색
count = 0#리프 노드의 개수
for i in range(len(arr)):#리프 노드의 개수를 세줌
    if arr[i] != -2 and i not in arr:#방문하지 않은 노드이면서 연결되어 있지 않으면
        count += 1#리프 노드의 개수를 세줌
print(count)#리프 노드의 개수 출력