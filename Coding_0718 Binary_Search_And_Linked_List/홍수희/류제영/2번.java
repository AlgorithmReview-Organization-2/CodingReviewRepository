# https://leetcode.com/problems/palindrome-linked-list/

'''
1. 아이디어 :
    Node의 총 길이를 카운트하고, String을 2개 만들어 비교 해줌
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    링크드리스트?
'''

class Solution {
    public boolean isPalindrome(ListNode head) {
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i < count / 2) {
                sb1.append(head.val);
            }
            if (count % 2 == 0) {
                if (i >= count / 2) sb2.append(head.val);
            } else {
                if (i > count / 2) sb2.append(head.val);
            }

            head = head.next;
        }
        sb1.reverse();

        return sb1.toString().equals(sb2.toString());
    }
}
