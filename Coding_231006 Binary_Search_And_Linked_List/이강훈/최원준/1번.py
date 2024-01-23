# https://www.acmicpc.net/problem/23309

'''
1. 아이디어 :
    이중 연결 라스트 (Doubly Linked List)로 풀 수 있다.
2. 시간복잡도 :
    모든 공사 : O(n)
3. 자료구조 :
    링크드리스트
'''


class ListNode:

    def __init__(self, val):
        self.val = val
        self.next = None
        self.prev = None


n, m = list(map(int, input().split()))
nums = list(map(int, input().split()))

curr = dummy = ListNode(nums[0])
for i in range(1, len(nums)):
    new_node = ListNode(nums[i])
    curr.next = new_node
    new_node.prev = curr
    curr = curr.next
curr.next = dummy
dummy.prev = curr

for i in range(m):
    commands = input().split()
    for i in range(1, len(commands)):
        commands[i] = int(commands[i])
    while curr.val != commands[1]:
        curr = curr.next

    if len(commands) == 3:  # 설립
        new_node = ListNode(commands[2])

        if commands[0] == "BN":
            print(curr.next.val)
            cprev = curr
            cnext = curr.next

        elif commands[0] == "BP":
            print(curr.prev.val)
            cprev = curr.prev
            cnext = curr

        cprev.next = new_node
        new_node.next = cnext

        new_node.prev = cprev
        cnext.prev = new_node

    elif len(commands) == 2:  # 삭제

        if commands[0] == "CN":
            print(curr.next.val)
            cprev = curr
            cnext = curr.next.next

        elif commands[0] == "CP":
            print(curr.prev.val)
            cprev = curr.prev.prev
            cnext = curr

        cprev.next = cnext
        cnext.prev = cprev



'''
BN 
$i$ 
$j$ : 고유 번호 
$i$를 가진 역의 다음 역의 고유 번호를 출력하고, 그 사이에 고유 번호 
$j$인 역을 설립한다.
BP 
$i$ 
$j$ : 고유 번호 
$i$를 가진 역의 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 
$j$인 역을 설립한다.
CN 
$i$ : 고유 번호 
$i$를 가진 역의 다음 역을 폐쇄하고 그 역의 고유 번호를 출력한다.
CP 
$i$ : 고유 번호 
$i$를 가진 역의 이전 역을 폐쇄하고 그 역의 고유 번호를 출력한다.
'''
