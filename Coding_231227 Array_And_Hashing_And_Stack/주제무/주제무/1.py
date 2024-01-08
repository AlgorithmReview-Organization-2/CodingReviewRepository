'''
https://acmicpc.net/problem/2800
괄호 제거

주제: 스택, 브루트 포스
시간복잡도: N

구현
정렬을 포함하지만 N에 비례하지 않고 괄호 최대 수 2^10에 비례함
스택으로 괄호의 index를 찾고 괄호를 지워 구현
중복된 식을 집합을 이용해 삭제
'''
def find_couple(exp):
    s, couple = [], []
    for idx, ele in enumerate(exp):
        if ele == "(":
            s.append(idx)
        elif ele == ")":
            couple.append((s.pop(), idx))
    return couple


def bf(arr, target, index, target_length, s):
    if len(arr) >= target_length:
        print_exp(arr, s)
        return

    for next in [target[index], None]:
        arr.append(next)
        bf(arr, target, index+1, target_length, s)
        arr.pop()


def print_exp(arr, s: str):
    indexes = []
    for a in arr:
        if a:
            indexes.extend(a)
    indexes.sort()

    s = [string for string in s]
    for i, index in enumerate(indexes):
        s.pop(index-i)
    result.append("".join(s))


result = []
expression = input()
couple = find_couple(expression)
bf([], couple, 0, len(couple), expression)
print(*sorted(list(set(result[:-1]))), sep="\n")
