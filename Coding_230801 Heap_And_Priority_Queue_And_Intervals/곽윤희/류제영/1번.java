# https://leetcode.com/problems/take-gifts-from-the-richest-pile/

'''
1. 아이디어 :
    우선순위 큐를 이용하여 쉽게 품
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

class Solution {
    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            queue.offer(gift);
        }

        while (k-- > 0) {
            queue.offer((int) Math.sqrt(queue.poll()));
        }

        return queue.stream()
            .mapToLong(Integer::longValue)
            .sum();
    }
}
