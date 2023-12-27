'''
https://school.programmers.co.kr/learn/courses/30/lessons/42577

주제: 해시
시간복잡도: nlogn

전화번호를 한자리씩 이어붙이면서 집합에 저장 후 있나없나 확인
'''


def solution(phone_book):

    s = set()
    for number in sorted(phone_book, key= lambda x: -len(x)):
        if number in s:
            return False
        for idx in range(1, len(number)+1):
            n = number[:idx]
            s.add(n)
    return True
