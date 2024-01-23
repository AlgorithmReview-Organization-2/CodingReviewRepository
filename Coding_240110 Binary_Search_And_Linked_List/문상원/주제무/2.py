'''
https://www.acmicpc.net/problem/1920

주제: 수 찾기
'''
def binary_search(
        arr: list,  # sorted list
        target: int):
    start, end = 0, len(arr) - 1

    while (True):
        if start > end:
            return None

        mid = (start + end) // 2
        if target == arr[mid]:
            return mid + 1
        elif target > arr[mid]:
            start = mid + 1
        else:
            end = mid - 1


N = int(input())
N_arr = sorted(list(map(int, input().split())))

M = int(input())
M_arr = list(map(int, input().split()))

r = ""
for ele in M_arr:
    if binary_search(N_arr, ele):
        print(1)
    else:
        print(0)