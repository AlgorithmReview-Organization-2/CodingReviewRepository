import sys

## 1. 재귀 : 시간초과
## 2. 모든 경우의수 배열에 append : 메모리 초과
## 3. 역추적 : 허무할정도로 빠르게 해결...


input=sys.stdin.readline

def main():

    S=input().rstrip()
    T=input().rstrip()

    ## T끝이 A면 A만 제거 or  B면 B제거 하고 reverse

    V=T

    while len(V)>len(S):
        if V[-1]=='A':
            V=V[:len(V)-1]
        elif V[-1]=='B':
            V=V[:len(V)-1]
            V=V[::-1]

    if V==S:
        print(1)
    else:
        print(0)

main()