import heapq# 우선순위 큐 사용

n = int(input())# 과제의 개수

hq = []# 과제 정보
max_day = 0# 과제 마감일
for i in range(n):# 과제 정보 입력
    d, w = map(int, input().split())# 과제 마감일, 과제 점수
    heapq.heappush(hq, (-w, d))# 과제 점수, 과제 마감일
    if max_day < d: # 과제 마감일 최댓값
        max_day = d# 과제 마감일 최댓값

assigned = [False] * (max_day + 1)# 과제를 할당했는지 여부

score = 0# 점수
while hq:# 과제가 남아있다면
    # 가장 스코어 높은 순으로 가져와서
    w, d = heapq.heappop(hq)# 과제 점수, 과제 마감일
    w = -w# 과제 점수

    # d일부터 1일 까지 거꾸로 돌면서 비어있는 날 중에 최대한 늦게 배정
    for i in range(d, 0, -1):# 과제 마감일부터 1일까지
        if assigned[i]:# 과제를 할당했다면
            continue# 넘어감

        assigned[i] = True# 과제를 할당했다고 표시
        score += w# 점수 추가
        break# 끝냄

print(score)# 점수 출력