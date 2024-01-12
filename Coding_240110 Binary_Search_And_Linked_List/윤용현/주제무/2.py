'''
https://leetcode.com/problems/copy-list-with-random-pointer/description/

주제: linked list
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
            return

        index_old_node = {id(head): 0}
        cur, index = head, 1
        while cur and cur.next:
            cur = cur.next
            index_old_node[id(cur)] = index
            index += 1

        old_head = head
        new_head = Node(old_head.val, None, None)

        index = 0
        index_new_node = {}
        new_arr = []
        # set next node
        while True:
            new_arr.append(new_head)
            index_new_node[new_head.val] = index
            index += 1

            if old_head.next:
                old_head = old_head.next
                new_head.next = Node(old_head.val, None, None)
                new_head = new_head.next
            else:
                break

        # set random node
        for new in new_arr:
            if head.random is not None:
                random_index = index_old_node[id(head.random)]
                new.random = new_arr[random_index]
            head = head.next

        return new_arr[0]
