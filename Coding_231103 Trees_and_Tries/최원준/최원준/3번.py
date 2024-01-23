# https://leetcode.com/problems/construct-quad-tree/description/

'''
1. 아이디어 :
    리프인지 확인하는 메서드, 리프가 아닐때 반으로 자르는 메서드, 그리고 dfs를 만든다.
2. 시간복잡도 :
    O(4**n)
3. 자료구조 :
    배열
'''

"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':

        def is_leaf(arr) -> bool:
            if not arr:
                return True
            base = arr[0][0]
            for i in range(len(arr)):
                for j in range(len(arr)):
                    if arr[i][j] != base:
                        return False
            return True

        def segment(place, arr):
            if not arr:
                return
            n = len(arr)//2
            new_arr = []
            if place == "topLeft":
                for i in range(n):
                    temp = []
                    for j in range(n):
                        temp.append(arr[i][j])
                    new_arr.append(temp.copy())

            elif place == "topRight":
                for i in range(n):
                    temp=[]
                    for j in range(n, n*2):
                        temp.append(arr[i][j])
                    new_arr.append(temp)

            elif place == "bottomLeft":
                for i in range(n, n*2):
                    temp = []
                    for j in range(n):
                        temp.append(arr[i][j])
                    new_arr.append(temp.copy())

            elif place == "bottomRight":
                for i in range(n, n*2):
                    temp=[]
                    for j in range(n, n*2):
                        temp.append(arr[i][j])
                    new_arr.append(temp.copy())

            return new_arr

        def dfs(grid):
            node = Node()
            if is_leaf(grid):
                node.isLeaf = True
                node.val = grid[0][0]
            else:
                node.isLeaf = False
                node.topLeft = dfs(segment("topLeft", grid))
                node.topRight = dfs(segment("topRight",grid))
                node.bottomLeft = dfs(segment("bottomLeft", grid))
                node.bottomRight = dfs(segment("bottomRight", grid))
            return node

        return dfs(grid)


