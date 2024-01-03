import sys  # sys 모듈을 임포트하여 표준 입력을 사용합니다.

# 나무 이름의 출현 횟수를 저장할 딕셔너리
tree_count = {}
total_trees = 0  # 전체 나무의 수를 저장할 변수

# 입력의 끝까지 나무 이름을 읽어 처리합니다.
for tree in sys.stdin:
    tree = tree.strip()  # 입력받은 나무 이름의 양쪽 공백(줄바꿈 포함)을 제거합니다.
    if tree == '':  # 빈 줄이 입력되면 종료합니다.
        break
    if tree in tree_count:
        tree_count[tree] += 1  # 나무 이름이 이미 딕셔너리에 있으면 카운트를 1 증가시킵니다.
    else:
        tree_count[tree] = 1  # 나무 이름이 딕셔너리에 없으면 새로운 항목으로 추가합니다.
    total_trees += 1  # 전체 나무 수를 1 증가시킵니다.

# 나무 이름을 사전 순으로 정렬하여 출력합니다.
for tree in sorted(tree_count.keys()):
    percentage = (tree_count[tree] / total_trees) * 100  # 나무의 출현 비율을 백분율로 계산합니다.
    # 나무 이름과 출현 비율을 출력합니다. 비율은 소수점 넷째 자리까지 표시됩니다.
    print(f"{tree} {percentage:.4f}")
