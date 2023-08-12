# https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/

'''
1. 아이디어 :
    Set을 사용하면 금방 품
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    셋
'''

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(num > 0)  set.add(num);
        }
        
        return set.size();
    }
}
