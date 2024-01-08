'''
https://leetcode.com/problems/time-based-key-value-store/

주제: 해시
시간복잡도: N

key: value에서 value에 리스트로 값과 시간을 넣는다.
timestamp가 따로 주어지길래 무작위로 주어질 거 같아 이분탐색으로 삽입하는 방식으로 구현
'''

from bisect import bisect_left


class TimeMap:

    def __init__(self):
        self._dict = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self._dict:
            self._dict[key] = [[value], [timestamp]]
            return

        index = bisect_left(self._dict[key][1], timestamp)
        self._dict[key][0].insert(index, value)
        self._dict[key][1].insert(index, timestamp)

    def get(self, key: str, timestamp: int) -> str:
        if key not in self._dict:
            return ""
        idx = bisect_left(self._dict[key][1], timestamp)
        if self._dict and idx < len(self._dict[key][1]) and self._dict[key][1][idx] == timestamp:
            return self._dict[key][0][idx]
        return self._dict[key][0][idx-1] if idx > 0 else ""


input_1 = ["TimeMap","set","set","get","set","get","get"][1:]
input_2 = [[],["a","bar",1],["x","b",3],["b",3],["foo","bar2",4],["foo",4],["foo",5]][1:]

test = TimeMap()
for i in range(len(input_2)):
    if input_1[i] == "set":
        test.set(*input_2[i])
    else:
        print(test.get(*input_2[i]))