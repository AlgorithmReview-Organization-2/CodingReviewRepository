# https://school.programmers.co.kr/learn/courses/30/lessons/118667 두 큐 합 같게 만들기

'''
1. 아이디어 :
    queue 두개를 서로 이어서 index 에러가 안나게 한다.
    투 포인터를 사용해서 하나의 큐에 총 합의 반 값이 되도록 더하고 뺴기를 반복
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''


def solution(queue1, queue2):
    target = (sum(queue1) + sum(queue2)) // 2
    total = sum(queue1)
    queue1, queue2 = queue1 + queue2, queue2 + queue1
    p1 = p2 = 0
    count = 0
    while total != target:
        if p2 == len(queue1) or p1 == len(queue1):
            return -1
        if total < target:
            total += queue2[p2]
            p2 += 1
        elif total > target:
            total -= queue1[p1]
            p1 += 1
        count += 1
    return count
