# https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

'''
1. 아이디어 :
    정렬되어 주어지니깐 양수, 음수를 따로 계산하여 큰 값을 출력
2. 시간복잡도 :
    O(n)
3. 자료구조 :

'''

class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>=0) break;
            
            pos++;
        }
    
        int neg = 0;
        for(int i=nums.length - 1; i >= 0; i--) {
            if(nums[i]<=0) break;
            
            neg++;
        }
        
        return Math.max(pos, neg);
    }
}
