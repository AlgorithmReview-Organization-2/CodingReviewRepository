# https://www.acmicpc.net/problem/2800

'''
1. 아이디어 :
    dfs로 풀기에는 메모리가 부족.
    (, )의 인덱스를 저장하는 pairs 배열안에 저장.
    itertools combinations를 사용해서 pairs의 모든 조합을 all_combination에 저장
    all_combination을 돌면서, string 복사배열을 만들고, 각 combination안에 pairs 값에 따라 "" 처리한다.
2. 시간복잡도 :
    O(n) + O(2^(n/2)) + O(n) + O(nlogn) = O(2^(n/2))
3. 자료구조 :
    배열
'''
from itertools import combinations
import sys
input = sys.stdin.readline


string = list(input().rstrip())

stack, pairs = [], []

for i in range(len(string)):
    if string[i] == "(":
        stack.append(i)
    elif string[i] == ")":
        pairs.append((stack.pop(), i))

all_combinations = []
for length in range(1, len(pairs) + 1):
    all_combinations.extend(combinations(pairs, length))

ans = set()
for combinations in all_combinations:
    temp = string[:]
    for pair in combinations:
        left, right = pair
        temp[left] = ""
        temp[right] = ""
    ans.add("".join(temp))


ans = sorted(list(ans))
for a in ans:
    print(a)


'''
import itertools

# 반복 가능한 데이터셋과 조합의 길이를 지정
data = [1, 2, 3, 4]
length = 2

# itertools.combinations을 사용하여 모든 조합 생성
result = list(itertools.combinations(data, length))

print(result)
'''
