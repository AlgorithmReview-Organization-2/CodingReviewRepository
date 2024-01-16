import sys

input=sys.stdin.readline

# O(nlogn)

def main():
    N,M=map(int,input().split())

    tree_list=list(map(int,input().split()))
   # print(tree_list)

    low=0
    high=max(tree_list)



    while low<=high:

        mid = (low + high) // 2
        tmp_sum=0
        #print(low,mid,high)
        for i in tree_list:
            if (i-mid)<0:
                continue
            tmp_sum+=(i-mid)

        if tmp_sum>=M:
            low=mid+1
        else:
            high=mid-1


    print(high)





main()