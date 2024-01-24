# https://www.acmicpc.net/problem/23309 철도 공사

'''
1. 아이디어 :
    시간초과...가 날 수 있나...??
2. 시간복잡도 :
    O(m)
3. 자료구조 :
    더블링크드리스트, 해시맵
'''
import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None

n, m = list(map(int, input().split()))
nums = [int(num) for num in input().split()]
values = {}

for i in range(len(nums)):
    nums[i] = ListNode(nums[i])
    values[nums[i].val] = nums[i]

for i in range(len(nums)):
    nums[i-1].next = nums[i]
    nums[i].prev = nums[i-1]



for _ in range(m):
    inputs = input().split()
    if inputs[0] == "BN":
        i, j = int(inputs[1]), int(inputs[2])
        if j not in values:
            a_node = values[i]
            b_node = a_node.next

            print(b_node.val)
            new_node = ListNode(j)

            a_node.next = new_node
            new_node.next = b_node
            b_node.prev = new_node
            new_node.prev = a_node

            values[j] = new_node

    elif inputs[0] == "BP":
        i, j = int(inputs[1]), int(inputs[2])
        if j not in values:
            b_node = values[i]
            a_node = b_node.prev

            print(a_node.val)
            new_node = ListNode(j)

            a_node.next = new_node
            new_node.next = b_node
            b_node.prev = new_node
            new_node.prev = a_node

            values[j] = new_node

    elif inputs[0] == "CN":
        i = int(inputs[1])
        a_node = values[i]
        c_node = a_node.next.next

        print(a_node.next.val)

        a_node.next = c_node
        c_node.prev = a_node

    elif inputs[0] == "CP":
        i = int(inputs[1])
        c_node = values[i]
        a_node = c_node.prev.prev

        print(c_node.prev.val)

        a_node.next = c_node
        c_node.prev = a_node







# n = int(input().rstrip())
#
#
# s = input().rstrip()

# dp = [[0 for _ in range(n)] for _ in range(n)]
# dp = [[0 for j in range(n)] for i in range(n)]
# grid = [list(input().rstrip()) for _ in range(n)] # "aaa" "bbb"
# grid = list(list(map(int, input().split())) for _ in range(n)) # "0 0 0 0", "0 0 0 0"



