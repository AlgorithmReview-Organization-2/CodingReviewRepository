# https://www.acmicpc.net/problem/2096

'''
1. 아이디어 :
    dp로 풀 수 있다
2. 시간복잡도 :
    o(n)
3. 자료구조 :
    배열
'''
import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

n = int(input().rstrip())
max_integer_list = [int(num) for num in input().split()]
min_integer_list = max_integer_list.copy()

for i in range(n-1):
    left, mid, right = [int(num) for num in input().split()]

    max_temp = max_integer_list.copy()
    max_temp[0] = left + max(max_integer_list[0], max_integer_list[1])
    max_temp[1] = mid + max(max_integer_list[0], max_integer_list[1], max_integer_list[2])
    max_temp[2] = right + max(max_integer_list[1], max_integer_list[2])
    max_integer_list = max_temp.copy()

    min_temp = max_integer_list.copy()
    min_temp[0] = left + min(min_integer_list[0], min_integer_list[1])
    min_temp[1] = mid + min(min_integer_list[0], min_integer_list[1], min_integer_list[2])
    min_temp[2] = right + min(min_integer_list[1], min_integer_list[2])
    min_integer_list = min_temp.copy()

print(max(max_integer_list), min(min_integer_list))
