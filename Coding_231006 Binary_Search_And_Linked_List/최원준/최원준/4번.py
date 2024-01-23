# https://leetcode.com/problems/merge-k-sorted-lists/description/

'''
1. 아이디어 :
    링크드리스트를 합치는 작업 O(n)인데,
    1과 2를 실행하고, (1+2)+3을 실행하고, ((1+2)+3)+4 를 실행하면 O(n)이 나오지만,
    (1+2) + (3+4)를 실행하면 O(logn)이 나온다.
2. 시간복잡도 :
    O(n * logk)
3. 자료구조 :
    링크드 리스트
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        if len(lists) == 1:
            return lists[0]
        mid = len(lists)//2
        l, r = self.mergeKLists(lists[:mid]), self.mergeKLists(lists[mid:])
        return self.merge(l,r)

    def merge(self,l,r):
        dummy = pos = ListNode()
        while l and r:
            if l.val < r.val:
                pos.next = l
                l = l.next
            else:
                pos.next = r
                r = r.next
            pos = pos.next
        pos.next = l if l else r
        return dummy.next
