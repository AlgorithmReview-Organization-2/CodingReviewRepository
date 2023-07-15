# https://www.acmicpc.net/problem/12891

'''
1. 아이디어 :
    슬라이딩 윈도우. 한칸씩 옮기면서 ACGT의 갯수를 샌다.
2. 시간복잡도 :
    O(n) * 4
3. 자료구조 :
    해시맵, 배열
'''

s, p = map(int, input().split())
dna = input()
temp = list(map(int, input().split()))
counts = {"A": temp[0], "C": temp[1], "G": temp[2], "T": temp[3]}
cur_counts = {"A": 0, "C": 0, "G": 0, "T": 0}
ans, left, right = 0, 0, p-1

def check(cur_counts):
    for c in 'ACGT':
        if cur_counts[c] < counts[c]:
            return 0
    return 1

for i in range(p):
    cur_counts[dna[i]] += 1

while right < s-1:
    ans += check(cur_counts)
    cur_counts[dna[left]] -= 1
    left += 1
    right += 1
    cur_counts[dna[right]] += 1

ans += check(cur_counts)
print(ans)
