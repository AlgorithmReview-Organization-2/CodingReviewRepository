import sys

input=sys.stdin.readline

#set 으로 in 계산 빠르게 하기
#O(N)

def main():
    N=int(input())
    N_list=set(map(int,input().rstrip().split()))
    M=int(input())
    M_list = list(map(int, input().rstrip().split()))

    for i in M_list:
        if i in N_list:
            print(1)
        else:
            print(0)



main()