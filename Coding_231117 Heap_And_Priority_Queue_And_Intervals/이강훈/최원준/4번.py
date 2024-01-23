#https://school.programmers.co.kr/learn/courses/30/lessons/42627

'''
1. 아이디어 :
    현재(now) 실행할 수 있는(<=) job중에서 가장 시간이 짧은 걸(a) 구한다.
    a가 끝나고 now에 소요시간을 더한다.
    소요시간이 더해진 now를 기준으로 다시 job중에서 가장 시간이 짧은걸(a) 구한다.
    힙을 사용한다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    힙
'''

import heapq
def solution(jobs):
    jobs.sort(reverse = True)
    nums = len(jobs)
    candid = []
    counts = []
    now = 0

    while len(counts)!=nums:
        while jobs and jobs[-1][0]<=now:
            start, dur = jobs.pop()
            heapq.heappush(candid,[dur, start])
        if jobs and not candid:
            start, dur = jobs.pop()
            now = start
            heapq.heappush(candid,[dur, start])

        dur, start = heapq.heappop(candid)
        now += dur
        counts.append(now-start)
    return sum(counts)//nums

