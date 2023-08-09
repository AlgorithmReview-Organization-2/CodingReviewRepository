# https://leetcode.com/problems/relative-ranks/

'''
1. 아이디어 :
    내림차순으로 정리된 우선순위 큐와 score 배열을 비교해 같으면 answer 배열에 넣어줌
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : score) {
            queue.offer(num);
        }

        String[] answer = new String[score.length];
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < score.length; i++) {
                if (temp == score[i]) answer[i] = getRank(score.length - queue.size());
            }
        }

        return answer;
    }

    String getRank(int n) {
        if (n == 1) return "Gold Medal";
        else if (n == 2) return "Silver Medal";
        else if (n == 3) return "Bronze Medal";
        else return "" + n;
    }
}
