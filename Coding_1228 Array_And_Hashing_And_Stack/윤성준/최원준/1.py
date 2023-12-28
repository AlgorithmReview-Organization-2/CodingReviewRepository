# https://www.acmicpc.net/problem/4358

'''
1. 아이디어 :
    해시맵을 사용한다.
2. 시간복잡도 :
    O(N)
3. 자료구조 :
    해시맵
'''

from collections import defaultdict
import sys

input = sys.stdin.readline
tree_map = defaultdict(int)
count = 0

while True:
    tree = sys.stdin.readline().rstrip()
    if not tree:
        break
    tree_map[tree] += 1
    count += 1


trees = ([k, v / count * 100] for k, v in tree_map.items())
trees = sorted(trees, key=lambda x: x[0])

for tree in trees:
    print('%s %.4f' % (tree[0], tree[1]))
