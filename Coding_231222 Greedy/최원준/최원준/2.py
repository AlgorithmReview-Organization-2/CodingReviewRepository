# https://leetcode.com/problems/merge-triplets-to-form-target-triplet/description/

'''
1. 아이디어 :
    두가지를 확인한다.
    첫째, 각 Triplet의 인자가 하나라도 target보다 크면 해당 triplet은 제외한다.
    둘째, 남은 triplet들의 각 인자 중에 target의 왼쪽, 중간, 오른쪽 값이 없으면 모든 triplet을 합쳐도 해당 target의 값을 얻을 수 없다.
    위 조건을 모두 통과하면 True를 반환한다.
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    배열
'''

class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        candid_triplets = []
        for x,y,z in triplets:
            if x<=target[0] and y<=target[1] and z<=target[2]:
                candid_triplets.append((x,y,z))

        l=m=r= False
        for x,y,z in candid_triplets:
            if l==False and x == target[0]:
                l=True
            if m==False and y == target[1]:
                m=True
            if r==False and z == target[2]:
                r=True

        return (l and m and r)
