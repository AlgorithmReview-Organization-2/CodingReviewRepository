# https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

'''
1. 아이디어 :
    내림차순으로 정렬된 우선순위 큐에서 값 2개를 뽑아서 계산
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

class Solution {
    public int maxProduct(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }

        return (queue.poll() - 1) * (queue.poll() - 1);
    }
}
