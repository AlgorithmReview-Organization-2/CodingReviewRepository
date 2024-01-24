import sys

n = int(sys.stdin.readline().rstrip())  # 입력을 빠르게 받음

ans = [0] * n  # 답을 저장할 리스트를 0으로 초기화
A = list(map(int, sys.stdin.readline().split()))
myStack = []  # 인덱스를 추적하기 위한 스택
for i in range(n):
    # 스택이 비어있지 않고 현재 원소가 스택의 최상위 인덱스가 가리키는 원소보다 크면
    while myStack and A[myStack[-1]] < A[i]:
        ans[myStack.pop()] = A[i]  # 최상위 인덱스에 대한 답을 현재 원소로 업데이트
    myStack.append(i)  # 현재 인덱스를 스택에 추가
while myStack:  # 메인 루프 이후 스택에 원소가 남아있다면
    ans[myStack.pop()] = -1  # 다음 큰 원소가 없으므로 -1로 설정
result = ""
for i in range(n):
    result += str(ans[i]) + ""
print(result)  # 결과를 문자열로 포맷해서 출력
