# https://school.programmers.co.kr/learn/courses/30/lessons/92334?language=python3

'''
1. 아이디어 :
    총 신고를 받은 사람을 알기위해, report에 신고자, 피신고자를 해시맵[피신고자] : set(신고자)로 저장
    set(신고자)의 길이가 k가 넘으면, 해당 유저는 정지.
    set(신고자)안에 신고자들에게 메일을 주기위해, 신고자 이름이 등장할때마다 해시맵[신고자] + 1 로 만든다.
    id_list = 해시맵[id_list]로 값을 바꾼다.
2. 시간복잡도 :
    n^2
3. 자료구조 :
    해시맵
'''

from collections import defaultdict
def solution(id_list, reports, k):
    reported_users = defaultdict(set)
    for report in reports:
        reporter, reported = report.split(" ")
        reported_users[reported].add(reporter)

    alarm_user = defaultdict(int)
    for key, value in reported_users.items():
        if len(value) >= k:
            for user in value:
                alarm_user[user] += 1

    for i in range(len(id_list)):
        id_list[i] = alarm_user[id_list[i]]
    return id_list
