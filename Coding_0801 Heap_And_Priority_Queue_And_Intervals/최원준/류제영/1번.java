# https://leetcode.com/problems/last-stone-weight/

'''
1. 아이디어 :
    우선순위 큐를 이용하여 쉽게 품
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int num1 = queue.poll();
            int num2 = queue.poll();

            if (num1 != num2) {
                queue.offer(num1 - num2);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
