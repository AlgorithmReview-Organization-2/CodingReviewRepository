/*
https://leetcode.com/problems/median-of-two-sorted-arrays/

아이디어
원준이형 강의 링크 봤는데 구현이 안됨 실패

자료구조

시간복잡도

*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = total / 2;

        if (nums1.length > nums2.length) {
            int[] temp = nums1.clone();
            nums1 = nums2;
            nums2 = temp;
        }

        int l = 0;
        int r = nums1.length - 1;
        int m = (l + r) / 2;
        int nums2Position = half - (m + 2);
        int nums1Next = m < nums1.length - 1 ? nums1[m + 1] : Integer.MAX_VALUE;
        int nums2Next = nums2Position < nums2.length - 1 ? nums2[nums2Position + 1] : Integer.MAX_VALUE;
        while (l <= r) {
            if (nums1[m] > nums2Next) r = m - 1;
            else if (nums2[nums2Position] > nums1Next) l = m + 1;
            else break;

            m = (l + r) / 2;
            nums2Position = half - (m + 2);

            nums1Next = m < nums1.length - 1 ? nums1[m + 1] : Integer.MAX_VALUE;
            nums2Next = nums2Position < nums2.length - 1 ? nums2[nums2Position + 1] : Integer.MAX_VALUE;
        }

        return total % 2 == 0
                ? (double) (Math.max(nums1[m], nums2[nums2Position]) + Math.min(nums1Next, nums2Next)) / 2
                : Math.min(nums1Next, nums2Next);
    }
}