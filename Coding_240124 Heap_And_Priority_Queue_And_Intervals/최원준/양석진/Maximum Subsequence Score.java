class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums2.length;
        int[][] pairs = new int[n][2];
        for(int i=0; i<n; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long topKSum = 0;
        for(int i=0; i<k; i++) {
            topKSum += pairs[i][0];
            pq.offer(pairs[i][0]);
        }

        long ret = topKSum * pairs[k-1][1];

        for (int i=k; i < n; i++) {
            int minValue = pq.poll();
            topKSum += pairs[i][0] - minValue;
            pq.offer(pairs[i][0]);

            ret = Math.max(ret, topKSum * pairs[i][1]);
        }

        return ret;
    }
}