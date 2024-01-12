'''
https://www.acmicpc.net/problem/1654

주제:
시간복잡도: KlogN, 단 N은 랜선의 랜선 중 가장 짧은 길이

구현
가장 긴 랜선과 0 사이의 값 중에서 이분탐색을 통해 주어진 N보다 같거나 클 수 있도록 랜선을 자른다.

주의할 점
오영식이 들고 있는 모든 랜선을 쓸 필요는 없다.
가장 긴 랜선만으로도 N을 얻으면서 길이를 최대로 얻을 수 있기 때문에 가장 긴 랜선을 기준으로 구한다.

zerodivision을 조심하자.
'''
import sys
input = lambda: sys.stdin.readline().rstrip()

K, N = map(int, input().split())
lines = [int(input()) for _ in range(K)]

max_line = 0
l, r = 0, max(lines)
while l <= r:
    mid = (l+r) // 2

    cnt = 0
    for line in lines:
        cnt += line // mid if mid else line
    if cnt >= N:
        max_line = mid
        l = mid+1
    else:
        r = mid-1

print(max_line)
