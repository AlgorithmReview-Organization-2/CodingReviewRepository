# https://leetcode.com/problems/insert-interval/

'''
1. 아이디어 :
    겹치는 부분이 있으면 start와 end를 바꿔주고, start와 end보다 작거나 크면 리스트에 넣어줌
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    리스트
'''

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        
        if (intervals.length == 0) return new int[][]{newInterval};

        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            
            if (currentEnd < start) {
                list.add(new int[]{currentStart, currentEnd});
            } else if (currentStart > end) {
                list.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            } else {
                start = Math.min(start, currentStart);
                end = Math.max(end, currentEnd);
            }
        }
        list.add(new int[]{start, end});

        return list.toArray(int[][]::new);
    }
}
