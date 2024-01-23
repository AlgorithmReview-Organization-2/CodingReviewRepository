# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    1) Trie로 풀 수 있는 문제이다. 먼저 hashmap에 전화번호를 한 자리씩 등록하면서, 중복이 되는지 확인한다.
2. 시간복잡도 :
    1) O(n) * O(1) * O(1) = O(n) * t
    - n개의 전화번호를 등록하는데, 각각의 전화번호를 등록하는데 O(1)이 걸리고, 중복이 되는지 확인하는데 O(1)이 걸린다.
3. 자료구조 :
    1) Trie
'''

import sys

input = sys.stdin.readline


class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False


class Trie:
    def __init__(self):
        self.root = TrieNode()


t = int(input())
for tests in range(t):
    Tries = Trie()
    n = int(input())
    ans = "YES"
    for nums in range(n):
        phone = input().rstrip()
        cur = Tries.root
        for i in range(len(phone)):
            if cur.endOfWord:
                ans = "NO"
                break
            if phone[i] in cur.children and i == len(phone) - 1:
                ans = "NO"
                break
            if phone[i] not in cur.children:
                cur.children[phone[i]] = TrieNode()
            cur = cur.children[phone[i]]
        cur.endOfWord = True
    print(ans)

