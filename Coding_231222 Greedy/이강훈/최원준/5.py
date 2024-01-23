#https://school.programmers.co.kr/learn/courses/30/lessons/42884

'''
1. 아이디어 :
    camera = -30001부터 시작한다. 카메라 위치는 -30001부터 camera 까지의 범위로 생각하면된다.
    routes를 도착 기준으로 정렬한다.
    routes의 start와 end를 기준으로, 현재 카메라의 최대 거리보다 start가 작으면 (camera < start), 겹치지 않기때문에 카메라가 하나 더 필요하다.
    answer를 1 증가시키고, 해당 범위에 카메라를 설치했으므로, 그 범위의 end로 카메라 위치를 갱신한다.
2. 시간복잡도 :
    O(nlogn)
3. 자료구조 :
    배열
'''

def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1])
    camera = -30001

    for start, end in routes:
        if camera < start:
            answer += 1
            camera = end
    return answer
