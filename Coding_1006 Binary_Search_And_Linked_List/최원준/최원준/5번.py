#https://leetcode.com/problems/reverse-nodes-in-k-group/description/

'''
1. 아이디어 :
    0 -> 1 -> 2 -> 3 -> 4 -> 5
    역전 시킬 그룹 전 노드(groupPrev)와, 역전 시킬 그룹 다음 노드(groupNext)를 저장한다.
    0    2 -> 1    3 -> 4 -> 5
    해당 그룹을 역전 시킨다.
    0 -> 2 -> 1 -> 3 -> 4 -> 5
    groupPrev를 해당 그룹의 첫 노드로 연결 시키고, 해당 그룹의 마지막 노드를 groupNext로 연결시킨다.
    0 -> 2 -> 1 -> 4 -> 3 -> 5
    반복하다가, 역전시킬 그룹이 k보다 작으면 break 한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    링크드리스트
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        groupPrev = dummy

        while True:
            kth = self.getKth(groupPrev, k)
            if not kth:
                break
            groupNext = kth.next

            prev, curr = kth.next, groupPrev.next

            while curr != groupNext:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp

            temp = groupPrev.next
            groupPrev.next = kth
            groupPrev = temp

        return dummy.next

    def getKth(self, curr, k):
        while curr and k>0:
            curr = curr.next
            k-=1
        return curr


