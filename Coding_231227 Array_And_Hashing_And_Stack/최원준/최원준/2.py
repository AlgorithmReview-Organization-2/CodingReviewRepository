#https://leetcode.com/problems/maximum-frequency-stack/description/

'''
1. 아이디어 :
    counts : 각 숫자의 빈도수를 저장하는 해쉬맵
    freqs : 각 빈도수에 해당하는 숫자들을 저장하는 해쉬맵
2. 시간복잡도 :
    push : O(1)
    pop : O(1)
3. 자료구조 :
    해쉬맵
'''

from collections import defaultdict
class FreqStack:

    def __init__(self):
        self.counts = defaultdict(int)
        self.freqs = defaultdict(list)
        self.max_freq = 0
    def push(self, val: int) -> None:
        self.counts[val] +=1
        self.freqs[self.counts[val]].append(val)
        self.max_freq = max(self.max_freq, self.counts[val])

    def pop(self) -> int:
        result = self.freqs[ self.max_freq].pop()
        if not self.freqs[ self.max_freq]:
            self.max_freq -= 1
        self.counts[result] -= 1
        return result


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()
