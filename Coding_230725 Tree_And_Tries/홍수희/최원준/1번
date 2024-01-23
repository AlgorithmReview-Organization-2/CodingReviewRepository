# https://www.acmicpc.net/problem/14244

'''
1. 아이디어 :
    백준 트리는 진짜 문제 그지같다.....
    m이 2일 때는 leaf가 1개이다
    n이 1부터 n까지 순회하면서
    m이 leaf보다 크면, 0과 i를 출력한다.
    m이 leaf보다 작으면, last와 i를 출력한다.
    last는 i로 갱신한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    숫자
'''

n, m = map(int, input().split())

leaf = 1 if m == 2 else 0
last = 0

for i in range(1, n):
    if m > leaf:
        print(0, i)
        leaf += 1
    else:
        print(last, i)
    last = i
