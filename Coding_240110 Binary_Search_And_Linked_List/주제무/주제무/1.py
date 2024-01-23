'''
https://www.acmicpc.net/problem/20444

주제: 이분 탐색
시간복잡도: logN

구현
n의 크기를 하나씩 늘려보며 문제를 이해하고
가위질을 방향에 카운터함으로 색종이 개수가 정해짐을 이해한다.
한 방향의 가위질을 이분탐색하여 해결한다.
'''
def cut_paper(n, row):
    col = n - row
    return (row+1) * (col+1)


n, k = map(int, input().split())

answer = None
s, e = 0, n//2
while s <= e:
    mid = (s+e) // 2

    paper_cnt = cut_paper(n, mid)
    if k > paper_cnt:
        s = mid+1
    elif k < paper_cnt:
        e = mid-1
    else:
        answer = mid
        break

print("YES" if answer is not None else "NO")
