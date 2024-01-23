# https://school.programmers.co.kr/learn/courses/30/lessons/43163

'''
1. 아이디어 :
    bfs로 a~z까지 대입을 하면서 찾아간다.
    visited를 통해 재방문하지 않도록 한다
2. 시간복잡도 :
    O( length * 26 )
3. 자료구조 :
    큐
'''

from collections import deque

def solution(begin, target, words):

    queue = deque()
    words = set(words)
    visited = set()
    queue.append((begin,0))
    visited.add(begin)
    while queue:
        word, count = queue.popleft()
        if word == target:
            return count
        for i in range(len(word)):
            left = word[:i]
            right = word[i+1:]

            for j in range(26):
                temp_word = left + chr(97+j) + right
                if temp_word in words and temp_word not in visited:
                    visited.add(temp_word)
                    queue.append((temp_word, count+1))

    return 0
