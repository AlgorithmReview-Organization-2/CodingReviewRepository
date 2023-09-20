#https://leetcode.com/problems/group-anagrams/

'''
1. 아이디어 :
    같은 chars 끼리 해시맵으로 묶어주고, 그 해시맵의 value들을 리스트에 넣어주면 된다.
2. 시간복잡도 :
    O(n) * O(100log100) = O(n)
3. 자료구조 :
    해시맵
'''

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        words = {}
        ans = []
        for s in strs:
            letters = "".join(sorted(s))
            if letters not in words:
                words[letters] = [s]
            else:
                words[letters].append(s)

        for k,v in words.items():
            ans.append(v)

        return ans
