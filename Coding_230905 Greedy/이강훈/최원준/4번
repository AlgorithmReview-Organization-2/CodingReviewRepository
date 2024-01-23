# https://www.acmicpc.net/problem/1041

'''
1. 아이디어 :
    정육면체를 생각해본다.
    주사위의 1개의 면이 노출되는 경우, 2개의 면이 노출되는 경우, 3개의 노출되는 면의 합이 작아야되고,
    반대방향에 있는 두개의 숫자의 최소값을 노출면으로 둔다.
2. 시간복잡도 :
    O(1)
3. 자료구조 :
    배열
'''

n = int(input())
dice = list(map(int, input().split()))

one_side = 4 * (n - 2) * (n - 1) + (n - 2) ** 2  # 옆과 위
two_side = 4 * (n - 1) + 4 * (n - 2)
three_side = 4

temp = []
corner = []

if n == 1:
    ans = sum(sorted(dice)[:5])
else:
    temp.append(min(dice[0], dice[5]))
    temp.append(min(dice[1], dice[4]))
    temp.append(min(dice[2], dice[3]))
    corner = sorted(temp)

    one_min = corner[0]
    two_min = one_min + corner[1]
    three_min = two_min + corner[2]
    ans = one_side * one_min + two_side * two_min + three_side * three_min

print(ans)
