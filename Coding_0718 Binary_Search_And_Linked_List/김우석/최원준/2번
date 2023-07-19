#

'''
1. 아이디어 :
    1) 투 포인터
2. 시간복잡도 :
    1) O(n)
3. 자료구조 :
    1) 링크드리스트
'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cprev = None
        curr = head

        while curr:
            cnext = curr.next
            curr.next = cprev
            cprev = curr
            curr = cnext

        return cprev
