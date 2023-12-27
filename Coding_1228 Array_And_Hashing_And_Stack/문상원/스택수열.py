# 사용자로부터 정수 입력을 받아 'n'에 할당합니다. 'n'은 수열의 원소 개수를 나타냅니다.
n = int(input())

# 사용자로부터 'n'개의 정수 입력을 받아 리스트 'vector'를 초기화합니다. 이는 수열을 나타냅니다.
vector = [int(input()) for _ in range(n)]

# '+'와 '-' 연산의 순서를 저장할 빈 리스트 'resultV'를 초기화합니다.
resultV = []

# 스택 연산을 시뮬레이션하기 위해 빈 리스트 'stack'을 초기화합니다.
stack = []

# 순차적으로 스택에 넣을 숫자를 추적하기 위해 'num'을 1로 초기화합니다.
num = 1

# 수열을 스택 연산으로 생성할 수 있는지 여부를 추적하기 위해 'result'를 True로 초기화합니다.
result = True

# 'vector'의 각 요소 'su'를 순회하기 시작합니다.
for su in vector:

    # 'su'가 'num'보다 크거나 같으면 'su'에 도달할 때까지 숫자를 스택에 넣어야 합니다.
    if su >= num:
        # 'su'에 도달할 때까지 순차적으로 숫자를 스택에 넣습니다.
        while su >= num:
            stack.append(num)     # 스택에 'num'을 넣습니다.
            resultV.append('+')   # 각 푸시에 대해 '+' 연산을 기록합니다.
            num += 1              # 'num'을 다음 숫자로 증가시킵니다.
        stack.pop()               # 스택에서 가장 위에 있는 요소를 빼냅니다. 여기서는 'su'입니다.
        resultV.append('-')       # 팝 연산에 대해 '-'를 기록합니다.

    # 'su'가 'num'보다 작으면 팝 연산이 필요함을 나타냅니다.
    else:
        # 스택이 비어 있지 않고, 가장 위의 요소가 'su'보다 큰지 확인합니다.
        if stack and stack[-1] > su:
            print("NO")           # 수열을 생성할 수 없으면 "NO"를 출력합니다.
            result = False        # 실패를 나타내기 위해 'result'를 False로 설정합니다.
            break                 # 루프를 탈출하여 수열을 생성할 수 없음을 나타냅니다.
        else:
            stack.pop()           # 스택에서 가장 위에 있는 요소를 빼냅니다.
            resultV.append('-')   # 팝 연산에 대해 '-'를 기록합니다.

# 성공적으로 수열을 생성했으면 (result가 True이면) 연산들을 출력합니다.
if result:
    for r in resultV:
        print(r)                  # 'resultV'에 있는 각 연산 ('+' 또는 '-')을 출력합니다.
