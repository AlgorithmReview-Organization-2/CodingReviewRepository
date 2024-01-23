# https://leetcode.com/problems/minimum-interval-to-include-each-query/

'''
1. 아이디어 :
    2번째 풀이로는 시간초과.
    우선 intervals와 queries를 정렬한다.
    queries는 정렬전에, 순서를 저장해놓는다.
    힙을 만들어놓는다.
    queries의 q마다

    interval[idx]의 시작이 q마다 작으면 힙에 [길이, 마지막 번호]로 저장
    힙에 있는 길이가 제일 작은 원소의 마지막 번호가 q보다 작은지 확인(작으면 범위에 없다는 뜻)
    작으면 pop을 하고, 아니면 제일 작은 길이를 ans에 저장한다.
2. 시간복잡도 :

3. 자료구조 :

'''


#1)
import heapq
class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        queries_index = {}
        for i in range(len(queries)):
            if queries[i] not in queries_index:
                queries_index[queries[i]] = []
            queries_index[queries[i]].append(i)
        queries.sort()
        ans = [-1] * len(queries)

        min_heap = []
        intervals_index = 0
        for q in queries:
            while intervals_index < len(intervals) and intervals[intervals_index][0]<=q:
                start, end = intervals[intervals_index]
                heapq.heappush(min_heap,(end-start+1, end))
                intervals_index+=1
            while min_heap and min_heap[0][1] < q:
                heapq.heappop(min_heap)
            if min_heap:
                for queries_indexes in queries_index[q]:
                    ans[queries_indexes] = min_heap[0][0]

        return ans


#2)
import heapq
class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        min_interval = {}

        for start, end in intervals:
            for i in range(start, end+1):
                if i not in min_interval:
                    min_interval[i] = float('inf')
                min_interval[i] = min(min_interval[i], end-start+1)

        for i in range(len(queries)):
            queries[i] = min_interval[queries[i]] if queries[i] in min_interval else -1

        return queries
