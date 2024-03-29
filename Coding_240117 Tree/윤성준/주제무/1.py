'''
https://www.acmicpc.net/problem/20924

주제: 트리
'''
import sys
from collections import defaultdict
input = lambda : sys.stdin.readline().rstrip()


def make_tree(n_1, n_2, d):
    tree[n_1].append(n_2)
    if not cost[n_1]:
        cost[n_1] = {}
    cost[n_1][n_2] = d


def find_giga():
    global length_pilar

    stack, cur = [R], None
    while stack:
        cur = stack.pop()

        if len(tree[cur]) >= 2:
            break
        stack.extend(tree[cur])
        if tree[cur]:
            length_pilar += cost[cur][tree[cur][0]]

    return cur


def calculate_length_giga_to_leaf():
    global node_to_length_from_giga, stack, cur, child

    stack = [giga_node]
    while stack:
        cur = stack.pop()

        for child in tree[cur]:
            node_to_length_from_giga[child] = node_to_length_from_giga[cur] + cost[cur][child]
            stack.append(child)


N, R = map(int, input().split())

tree = [[] for _ in range(N+1)]
cost = defaultdict(dict)
for _ in range(N-1):
    a, b, d = map(int, input().split())
    make_tree(a, b, d)
    make_tree(b, a, d)

# tree 간선 정보에서 child만 남기기
stack = [R]
while stack:
    cur = stack.pop()
    for child in tree[cur]:
        tree[child].remove(cur)
        stack.append(child)

length_pilar = 0
giga_node = find_giga()

node_to_length_from_giga = {giga_node: 0}
calculate_length_giga_to_leaf()
print(length_pilar, max(node_to_length_from_giga.values()))
