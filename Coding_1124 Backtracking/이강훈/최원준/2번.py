# https://school.programmers.co.kr/learn/courses/30/lessons/172927

'''
1. 아이디어 :
    백트래킹으로 풀 수 있다.
    5개씩 빼므로, 처음 미네랄을 5배수로 만든다.
    calc_fatigue 메서드를 통해서 피로도를 계산한다.
    temp 배열을 만들어서, minerals에서 꺼낸 것들을 기록한다.
2. 시간복잡도 :
    O( len(picks) ** math.ceil(minerals%5) ) + O(mineral log mineral)
3. 자료구조 :
    배열
'''


def solution(picks, minerals):
    def backtrack(tired):
        if not minerals or sum(picks) == 0:
            ans[0] = min(ans[0], tired)
            return

        for i in range(len(picks)):
            if picks[i] != 0:
                temp = []

                picks[i] -= 1
                for _ in range(5):
                    m = minerals.pop()
                    tired += calc_fatigue(i, m)
                    temp.append(m)

                backtrack(tired)

                picks[i] += 1
                for _ in range(5):
                    m = temp.pop()
                    tired -= calc_fatigue(i, m)
                    minerals.append(m)

    def calc_fatigue(pick_idx, mineral):
        if mineral == "stone":
            return 1
        if mineral == "iron":
            return 5 if pick_idx == 2 else 1
        if mineral == "diamond":
            return 25 if pick_idx == 2 else 5 if pick_idx == 1 else 1
        return 0 #dummy

    while len(minerals) % 5 != 0:
        minerals.append("dummy")
    minerals = minerals[::-1]

    ans = [float('inf')]

    backtrack(0)
    return ans[0]
