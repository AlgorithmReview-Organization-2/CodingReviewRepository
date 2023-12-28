'''
https://school.programmers.co.kr/learn/courses/30/lessons/92334
신고 결과 받기

주제: 해시
시간복잡도: N^2
'''

def solution(id_list, report, k):
    answer = []

    rep_docs = {id: set() for id in id_list}
    acc_rep = {id: 0 for id in id_list}

    for rep in report:
        sender, receiver = rep.split()
        if receiver not in rep_docs[sender]:
            acc_rep[receiver] += 1
            rep_docs[sender].add(receiver)

    for id, acc in acc_rep.items():
        if acc < k:
            acc_rep[id] = False

    for id in id_list:
        s = 0
        for receiver in rep_docs[id]:
            if acc_rep[receiver]:
                s += 1
        answer.append(s)
    return answer