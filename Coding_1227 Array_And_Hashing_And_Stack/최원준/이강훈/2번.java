/*
https://leetcode.com/problems/maximum-frequency-stack/description/

아이디어
각 숫자 : 사용 횟수 ( map )
사용 횟수를 index : Stack ( list )
가장 많은 횟수의 Stack 에서 pop 하고 사용 횟수 map 카운트 최신화

자료구조
HashMap, Stack, List

시간복잡도
O(N)
*/

import java.util.*;

public class FreqStack {
    Map<Integer, Integer> count = new HashMap<>();
    List<Stack<Integer>> stacks = new ArrayList<>();

    public FreqStack() {

    }

    public void push(int val) {
        int freq = count.getOrDefault(val, 0) + 1;
        count.put(val, freq);

        int index = freq - 1;
        if (stacks.size() == index) stacks.add(new Stack<>());

        stacks.get(index).push(val);
    }

    public int pop() {
        int num = stacks.get(stacks.size() - 1).pop();
        count.put(num, count.get(num) - 1);

        if (stacks.get(stacks.size() - 1).size() == 0) stacks.remove(stacks.size() - 1);

        return num;
    }
}
