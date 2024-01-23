# https://school.programmers.co.kr/learn/courses/30/lessons/1843#qna

'''
1. 아이디어 :
    dp로 푼다.
    1. dp[i][j] = i~j까지의 최대값
    2. 왼쪽 최대, 최소, 오른쪽 최대, 최소를 구하고,
    3. 중간 연산자가 + 이면, 최대는 왼쪽 최대 + 오른쪽 최대, 최소는 왼쪽 최소 + 오른쪽 최소
    4. 중간 연산자가 - 이면, 최대는 왼쪽 최대 - 오른쪽 최소 또는 왼쪽 최소 - 오른쪽 최대 중 큰 값, 최소는 왼쪽 최소 - 오른쪽 최대 또는 왼쪽 최대 - 오른쪽 최소 중 작은 값
2. 시간복잡도 :
    O(n^3)
3. 자료구조 :
    해시맵
'''

def solution(arr):
    max_memo = {}
    min_memo = {}

    def dfs(start, end, max_or_min):
        if (start, end) in max_memo:
            if max_or_min == "max":
                return max_memo[(start, end)]
            else:
                return min_memo[(start, end)]

        if start == end:
            return int(arr[start])

        max_val = -1e6
        min_val = 1e6

        candid=[]
        for i in range(start + 1, end, 2):
            max_left = dfs(start, i - 1, "max")
            min_left = dfs(start, i - 1, "min")
            max_right = dfs(i + 1, end, "max")
            min_right = dfs(i + 1, end, "min")

            if arr[i] == "+": # 양수이건, 음수이건, 항상 큰 값들의 합이 무조건 크다
                max_val = max(max_val, max_left + max_right)
                min_val = min(min_val, min_left + min_right)
            else: #max와 min 모두 음수 일수도 있으니 경우의 수가 2가지이다.
                max_val = max(max_val, max_left - min_right, min_left - max_right)
                min_val = min(min_val, min_left - max_right, max_left - min_right)


        max_memo[(start, end)] = max_val
        min_memo[(start, end)] = min_val
        return max(max_val, min_val)

    return dfs(0, len(arr) - 1, "max")

