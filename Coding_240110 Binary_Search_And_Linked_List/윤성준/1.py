import sys

input=sys.stdin.readline

def main():
    # 인터넷 참고했습니다 접해보진 못한 유형...
    # O(nlogn)

    N,M=map(int,input().split())
    arr=list(map(int,input().rstrip().split()))

    high=sum(arr)
    low=max(arr)
    mid=(high+low)//2

    while low<=high:

        blue_num = 1
        tmp_sum = 0
        i=0
        while i<N:
            tmp_sum+=arr[i]
            if tmp_sum>mid:
                blue_num+=1
                tmp_sum=0
                i-=1
            i+=1

        if blue_num<=M:
            high=mid-1
            mid=(high+low)//2
        else:
            low=mid+1
            mid=(high+low)//2


    print(high)



main()