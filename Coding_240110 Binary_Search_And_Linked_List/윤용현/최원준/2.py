# https://leetcode.com/problems/copy-list-with-random-pointer/description/

'''
1. 아이디어 :
    해시맵에 기존 노드 주소와 새로운 노드 배열 idx를 매핑해서 풀 수 있다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵, 링크드리스트

'''

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        address = {}

        ans = []
        curr = head
        i = 0
        while curr:
            new_node = Node(curr.val)
            ans.append(new_node)
            address[curr] = i
            curr=curr.next
            i+=1
        ans.append(0)

        curr = head
        i = 0
        while curr:
            ans[i].next = ans[i+1]
            if curr.random in address:
                ans[i].random = ans[address[curr.random]]
            curr = curr.next
            i+=1

        ans[-2].next = None
        return ans[0]
