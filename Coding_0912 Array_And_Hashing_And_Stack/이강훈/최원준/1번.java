# https://www.acmicpc.net/problem/4358

'''
1. 아이디어 :
    진짜 거지같은 입력 문제...
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    해시맵
'''
import sys
trees = {}
total = 0

while True:
    tree = sys.stdin.readline().rstrip()
    if not tree:
        break
    total += 1
    if tree not in trees:
        trees[tree] = 1
    else:
        trees[tree] += 1

trees = sorted([[k, round(v / total * 100, 4)] for k, v in trees.items()])
for tree in trees:
    print('%s %.4f' % (tree[0], tree[1]))
