# https://leetcode.com/problems/middle-of-the-linked-list/

'''
1. 아이디어 :
    길이 계산 후, 절반 만큼 이동 시킴
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    링크드리스트?
'''

class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        int mid = count / 2 + 1;

        for (int i = 1; i < mid; i++) {
            head = head.next;
        }
        
        return head;
    }
}
