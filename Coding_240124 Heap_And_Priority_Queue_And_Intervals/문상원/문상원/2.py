import sys
import heapq# 우선순위 큐 사용

input = sys.stdin.readline# 입력 빠르게 받기

N = int(input())# 회의의 수
logs = [list(map(int, input().split())) for _ in range(N)]# 회의 정보
logs.sort()  # 시작이 빠른 순으로 정렬

# 자리 카운트 셀 것
use_cnt = [0] * N# 사용 횟수
use_cnt[0] = 1# 첫번째 자리는 무조건 사용

# 사용중인 컴퓨터 끝나는시간과 자리 번호
pq = []# 우선순위 큐
heapq.heappush(pq, [logs[0][1], 0])  # 끝나는 시간, 자리 번호

# 남아있는 가장 자리들 ( 앞자리 뽑으려고 ) 
computers_pq = [i for i in range(N)]# 우선순위 큐
heapq.heapify(computers_pq)  # 자리만
heapq.heappop(computers_pq)# 첫번째 자리는 무조건 사용

for log in logs[1:]:  # 이미 넣었으니까 1부터 시작
    start, end = log#   시작시간, 끝나는 시간

    if pq[0][0] > start:  # 제일빨리 끝나는 애보다 시작 시간이 늦으면 남아 있는 다른 자리로 가라
        new_posi = heapq.heappop(computers_pq)# 남아있는 자리 중에서 가장 앞선 자리를 뽑는다.
        use_cnt[new_posi] += 1# 사용 횟수 추가
        heapq.heappush(pq, [end, new_posi])# 끝나는 시간, 자리 번호
    else:# 제일 빨리 끝나는 애보다 시작 시간이 빠르면
        while True:  # 사용중인 자리가 여러군데가 끝나있는 경우가 있다. 그 중에서 가장 앞선 자리를 뽑아야한다.
            prev_end, prev_seq = heapq.heappop(pq)# 끝나는 시간, 자리 번호
            if pq and pq[0][0] <= start:  # 그 다음 것도 이미 끝나있는 경우가 있다.
                heapq.heappush(computers_pq, prev_seq)# 사용중인 자리에 넣는다.
                continue# 다시 뽑아라
            else:# 그 다음 것도 이미 끝나있는 경우가 없다.
                new_posi = heapq.heappushpop(computers_pq, prev_seq)# 사용중인 자리에 넣고 뽑는다.
                heapq.heappush(pq, [end, new_posi])# 끝나는 시간, 자리 번호
                use_cnt[new_posi] += 1# 사용 횟수 추가
                break# 끝냄

idx = N - use_cnt.count(0)# 사용 횟수가 0인 것을 제외하고 개수를 센다.
print(idx)# 개수 출력
print(' '.join(list(map(str, use_cnt[:idx]))))# 사용 횟수 출력