/*
https://leetcode.com/problems/find-median-from-data-stream/

아이디어
풀이를 찾아봤지만 왜 되는지 모르겠다

자료구조
최소 PQ , 최대 PQ

시간복잡도
O ( N log N )
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smallpq;
    PriorityQueue<Integer> largepq;
    int numCount;

    public MedianFinder() {
        smallpq = new PriorityQueue<>();
        largepq = new PriorityQueue<>(Collections.reverseOrder());
        numCount = 0;
    }

    public void addNum(int num) {
        if (numCount % 2 == 0) {
            largepq.add(num);
            smallpq.add(largepq.poll());
        } else {
            smallpq.add(num);
            largepq.add(smallpq.poll());
        }
        numCount++;
    }

    public double findMedian() {
        if (numCount % 2 == 0) {
            return (smallpq.peek() + largepq.peek()) / 2.0;
        } else {
            return smallpq.peek();
        }
    }
}
