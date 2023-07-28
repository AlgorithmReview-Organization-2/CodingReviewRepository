# https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

'''
1. 아이디어 :
    이분 탐색으로 mid가 0보다 작을 때 계산함
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''

class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int[] ints : grid) {
            int lt = 0;
            int rt = ints.length - 1;
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                if(ints[mid] < 0) {
                    answer += rt - mid + 1;
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
        }

        return answer;
    }
}
