# https://leetcode.com/problems/reverse-linked-list/

'''
1. 아이디어 :
    앞 뒤로 노드를 바꿔주면 됨
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    링크드리스트?
'''

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}
