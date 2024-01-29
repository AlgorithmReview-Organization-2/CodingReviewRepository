import sys
import heapq# 우선순위 큐 사용

N, K = map(int, sys.stdin.readline().split())# 보석의 개수, 가방의 개수
jew = []# 보석 정보
for _ in range(N):# 보석 정보 입력
    heapq.heappush(jew, list(map(int, sys.stdin.readline().split())))# 무게, 가격
bags = []# 가방 정보
for _ in range(K):# 가방 정보 입력
    bags.append(int(sys.stdin.readline()))# 무게
bags.sort()# 무게 오름차순 정렬

answer = 0# 답
tmp_jew = []# 보석 정보
for bag in bags:# 가방 정보
    while jew and bag >= jew[0][0]:# 가방에 넣을 수 있는 보석 정보
        heapq.heappush(tmp_jew, -heapq.heappop(jew)[1])# 가격
    if tmp_jew:# 가방에 넣을 수 있는 보석이 있다.
        answer -= heapq.heappop(tmp_jew)# 가장 비싼 보석을 넣는다.
    elif not jew:# 가방에 넣을 수 있는 보석이 없다.
        break# 끝냄
print(answer)# 답 출력