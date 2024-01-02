package stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/maximum-frequency-stack/
// Ref: https://www.youtube.com/watch?v=Z6idIicFDOE&ab_channel=NeetCode
// TC: O(1), SC: O(N)
public class Problem2 {
}

class FreqStack {

    Map<Integer, Integer> cnt;
    Integer mxCnt;
    Map<Integer, Stack<Integer>> stacks;

    public FreqStack() {
        cnt = new HashMap<>();
        mxCnt = 0;
        stacks = new HashMap<>();
    }

    public void push(int val) {
        int freq = cnt.getOrDefault(val, 0) + 1;
        cnt.put(val, freq);
        if (freq > mxCnt) {
            mxCnt = freq;
            stacks.put(freq, new Stack<>());
        }
        stacks.get(freq).add(val);
    }

    public int pop() {
        Integer ret = stacks.get(mxCnt).pop();
        cnt.put(ret, cnt.get(ret) - 1);
        if (stacks.get(mxCnt).isEmpty()) {
            mxCnt--;
        }
        return ret;
    }
}
