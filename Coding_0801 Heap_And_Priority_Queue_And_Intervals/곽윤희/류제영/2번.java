# https://leetcode.com/problems/merge-intervals/

'''
1. 아이디어 :
    원준이형 2번 문제랑 비슷해서 코드만 살짝 고쳐서 품
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            int nextStart = intervals[i + 1][0];
            int nextEnd = intervals[i + 1][1];

            if (end < nextStart) {
                list.add(new int[]{start, end});
                start = nextStart;
                end = nextEnd;
            } else {
                start = Math.min(start, nextStart);
                end = Math.max(end, nextEnd);
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(int[][]::new);
    }
}
