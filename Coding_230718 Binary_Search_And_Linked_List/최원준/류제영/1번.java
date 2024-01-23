# https://leetcode.com/problems/missing-number/

'''
1. 아이디어 :
    연속된 수열에서 하나만 빠지니깐, "전체 수열의 합 - 빠진 수열의 합"으로 빠진 수를 구함
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    
'''

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        
        int temp = 0;
        for(int i=1; i<=nums.length; i++) {
            temp += i;
        }
        
        return temp - sum;
    }
}
