# https://school.programmers.co.kr/learn/courses/30/lessons/42577

'''
1. 아이디어 :
    이중포문으로 쉽게 풀린다.
2. 시간복잡도 :
    O(N^2)
3. 자료구조 :
    해시셋
'''

def solution(phone_book):
    phone_book = set(phone_book)
    for nums in phone_book:
        comparison = ""
        for n in nums:
            comparison += n
            if comparison in phone_book and comparison != nums:
                return False
    return True
