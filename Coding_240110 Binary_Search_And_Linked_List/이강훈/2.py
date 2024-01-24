import sys

input=sys.stdin.readline

#정렬하고 양 사이드부터 탐색
#두 포인터를 이용하였다. 절댓값 기준으로 절댓값 min
#일 때 값 저장
# O(n)
def main():
    N=int(input())
    arr=list(map(int,input().split()))

    arr.sort()

    pl=0
    pr=len(arr)-1

    near_zero=10000000000
    ppl,ppr=0,0
    while pl<pr:

        value=arr[pl]+arr[pr]

        if abs(value)<near_zero:
            near_zero=abs(value)
            ppl=arr[pl]
            ppr=arr[pr]

        if value<0:
            pl+=1
        elif value>0:
            pr-=1
        else:
            print(arr[pl],arr[pr])
            return

    print(ppl,ppr)



main()