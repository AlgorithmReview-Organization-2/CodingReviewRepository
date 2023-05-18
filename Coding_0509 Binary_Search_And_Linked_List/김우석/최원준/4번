# https://leetcode.com/problems/merge-in-between-linked-lists/

'''
1. 아이디어 :
    포인터를 3개 둔다. start는 remove직전의 노드, end는 remove직후의 노드, tail은 list2의 마지막 노드.
    start와 tail을 연결하고, tail과 end를 연결한다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    링크드리스트
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        start = list1
        for i in range(a-1):
            start = start.next
        end = start
        for i in range(b-a+2):
            end = end.next
        tail = list2
        while tail.next:
            tail = tail.next

        start.next = list2
        tail.next = end
        return list1
