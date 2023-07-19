# https://www.acmicpc.net/problem/1920

'''
1. 아이디어 :
    1) 이진탐색을 이용
    2) 중복을 제거해주는 set()을 이용
2. 시간복잡도 :
    1) 이진탐색 -  O(nlogn) + O(mlogn)= O(nlogn)
    - n : n개의 원소를 Sorting에 걸리는 시간 + m : m번 탐색에 걸리는시간
    2 ) set() - O(n) + O(m) = O(n)
    - n : n개에 원소를 set에 넣는데 걸리는 시간 (1) + m : m개의 원소를 set에서 찾는데 걸리는 시간 (1)
3. 자료구조 :
    1) 이진탐색
    2) 해시셋
'''


# 1)
def binarySearch(alist, target):
    start = 0
    end = len(alist) - 1
    while start <= end:
        mid = (start + end) // 2
        if alist[mid] == target:
            return 1
        elif alist[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0


n = int(input())
alist = list(map(int, input().split()))
alist.sort()
m = int(input())
blist = list(map(int, input().split()))
for i in blist:
    print(binarySearch(alist, i))




# 2)
noneed1, save_numbers, noneed2, check_numbers = input(), set(list(map(int, input().split()))), input(), list(map(int, input().split()))
for check_number in check_numbers:
    print(1 if check_number in save_numbers else 0)
