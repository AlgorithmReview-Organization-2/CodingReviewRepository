import sys
from math import sqrt

input=sys.stdin.readline
# 4번 자른다는 기준 n*m의 형태의 종의 이때 n+m=6인 case

def main():
    n,k=map(int,input().split())

    p=round(sqrt(k))
    #answer="NO"

    high=p
    low=1
    mid = (high+low) // 2

    while high>=low:

        #print(high,low)
        if mid*(n+2-mid)>k:

            high = mid - 1
            mid = (high + low) // 2
        elif mid*(n+2-mid)==k:
            print("YES")
            return
        else:
            low = mid + 1
            mid = (high + low) // 2

    print("NO")
    #k는 늘려




main()