# https://www.acmicpc.net/problem/14426

'''
1. 아이디어 :
    1) Trie 로 풀면된다. 각각 노드에 Hashmap과 끝을 알리는 변수를 만들어서 저장하고,
    끝나는 노드에는 변수를 True를 저장한다.
2. 시간복잡도 :
    1) O(n) * O(1) + O(n) * O(1) = O(n)
    - Trie에 저장하는 시간 + Trie에서 찾는 시간 * O(1)은 Trie에서 찾는 시간
3. 자료구조 :
    1) Trie
'''

import sys

input = sys.stdin.readline


class TrieNoode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False


class Trie:
    def __init__(self):
        self.root = TrieNoode()

    def _insert(self, word):
        cur = self.root
        for char in word:
            if char not in cur.children:
                cur.children[char] = TrieNoode()
            cur = cur.children[char]

    def _search(self, word):
        cur = self.root
        for char in word:
            if char not in cur.children:
                return False
            cur = cur.children[char]
        return cur.endOfWord

    def _startsWith(self, prefix):
        cur = self.root
        for char in prefix:
            if char not in cur.children:
                return False
            cur = cur.children[char]
        return True


n, m = map(int, input().split())
trie = Trie()
for _ in range(n):
    trie.insert(input().rstrip())
cnt = 0
for _ in range(m):
    if trie.startsWith(input().rstrip()):
        cnt += 1
print(cnt)
