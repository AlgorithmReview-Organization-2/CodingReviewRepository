from itertools import combinations
data = list(input())  # 사용자로부터 수식 입력 받아 리스트로 변환

stack = []  # 괄호의 인덱스를 임시 저장할 스택
index = []  # 괄호 쌍의 인덱스를 저장할 리스트
result = set()  # 생성된 모든 식을 저장할 집합 (중복 제거)

# 수식을 순회하며 괄호의 인덱스를 찾아냄
for i in range(len(data)):
    if data[i] == '(':
        stack.append(i)  # 열린 괄호의 인덱스를 스택에 저장
    elif data[i] == ')':
        index.append((stack.pop(), i))  # 닫힌 괄호를 만나면, 마지막 열린 괄호의 인덱스와 함께 저장

# 1개부터 모든 괄호 쌍을 제거하는 조합을 생성
for i in range(1, len(index)+1):
    com = list(combinations(index, i))  # 괄호 쌍의 인덱스로 가능한 모든 조합 생성
    for c in com:
        temp = data[:]  # 원본 수식 복사
        for x, y in c:
            temp[x] = ''  # 선택된 괄호 쌍의 열린 괄호 제거
            temp[y] = ''  # 선택된 괄호 쌍의 닫힌 괄호 제거
        result.add(''.join(temp))  # 수정된 수식을 문자열로 변환하여 결과 집합에 추가

# 결과를 리스트로 변환하고 사전순으로 정렬
result = list(result)
result.sort()

# 정렬된 결과를 출력
for i in result:
    print(i)
