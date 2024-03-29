'''
https://school.programmers.co.kr/learn/courses/30/lessons/118667

주제: 투 포인터
시간 복잡도: N

특이사항
q를 deque으로 변경하면 소요시간이 매우 증가함
'''
from collections import deque


def solution(queue1, queue2):
    tmp = queue1 + queue2 + queue1
    q = (tmp)
    p_1, p_2 = 0, len(queue1)

    s = sum(queue1 + queue2)
    if s % 2:
        return -1
    target = sum(queue1 + queue2) // 2

    cnt, cur_s = 0, sum(queue1)
    while cnt <= len(queue1)*3:
        if cur_s == target:
            return cnt

        cnt += 1
        if cur_s > target:
            cur_s -= q[p_1]
            p_1 += 1
        else:
            cur_s += q[p_2]
            p_2 += 1
    return -1
