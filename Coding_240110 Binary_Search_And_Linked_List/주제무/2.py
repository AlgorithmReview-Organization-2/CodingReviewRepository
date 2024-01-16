import sys

input=sys.stdin.readline

# O(nlogn)
def main():
    K,N=map(int,input().split())

    arr=[]
    for _ in range(K):
        arr.append(int(input()))


    high=max(arr)
    low=1
    mid=(high+low)//2

    ###??

    while high>=low:
        tmp_sum=0
        for i in range(K):
            tmp_sum+=arr[i]//mid

        if tmp_sum>=N:
            low=mid+1
        else:
            high=mid-1
        mid=(high+low)//2

    print(high)


main()