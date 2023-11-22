# https://school.programmers.co.kr/learn/courses/30/lessons/43164

'''
1. 아이디어 :
    중복되는 티켓이 있다는 얘기가 없어서 해시맵으로 했다가, 중복되는 티켓이 존재해서 갈아 엎었다.....
    used 배열을 만들어서 사용한 티켓을 추적한다.
    path의 길이가 tickets의 길이+1 과 같으면 모든 도착지를 방문했으므로, path를 저장한다.
    티켓을 돌면서, 사용 안한 티켓중, 티켓의 시작점이 마지막 방문지와 같으면 재귀를 돌린다.
    마지막으로 ans를 정렬하여 제일 앞의 값을 리턴
2. 시간복잡도 :
    O(n!)
3. 자료구조 :
    배열
'''


def solution(tickets):
    def backtrack(start, path):
        if len(path) == len(tickets) + 1:
            ans.append(path.copy())

        for i in range(len(tickets)):
            if not used[i] and tickets[i][0] == start:
                used[i] = True
                path.append(tickets[i][1])

                backtrack(tickets[i][1], path)

                path.pop()
                used[i] = False

    used = [False] * len(tickets)
    ans = []

    backtrack("ICN", ["ICN"])
    ans.sort()

    return ans[0]
