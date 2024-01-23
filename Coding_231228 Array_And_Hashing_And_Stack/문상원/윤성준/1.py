def canTransform(S, T):
    # T에서 시작하여 S를 만들 수 있는지 확인
    while len(T) > len(S):
        # 만약 T의 마지막 문자가 'A'라면, 그 문자를 제거
        if T[-1] == 'A':
            T = T[:-1]
        # 만약 T의 마지막 문자가 'B'라면, 그 문자를 제거하고 문자열을 뒤집음
        elif T[-1] == 'B':
            T = T[:-1][::-1]

    # 최종적으로 S와 T가 같은지 확인
    return S == T


# 입력 받기
S = input().strip()
T = input().strip()

# 결과 출력
if canTransform(S, T):
    print(1)  # S를 T로 만들 수 있음
else:
    print(0)  # S를 T로 만들 수 없음
