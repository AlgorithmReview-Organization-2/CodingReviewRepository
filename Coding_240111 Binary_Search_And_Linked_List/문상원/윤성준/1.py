#run binary search
N,M=map(int,input().split())
A=list(map(int,input().split()))
start=0
end=0


for i in A:
    if start<i:
        start=i#최대값을 찾아 인덱스를 저장
    end+=i#모든 값의 합을 종료 인덱스로 저장
    
while start<=end:
    middle=int((start+end)/2)
    sum=0
    count=0
    
    for i in range(N):#중간값으로 모든레슨을 저장할수있는지확인
        if sum+A[i]>middle:
            count+=1
            sum=0
        sum+=A[i]
    if sum!=0:
        count+=1
    if count>M:#모든레슨을 저장할수없으면
        start=middle+1
    else:#모든레슨을 저장할수있으면
        end=middle-1