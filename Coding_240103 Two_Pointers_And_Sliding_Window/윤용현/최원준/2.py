# https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

'''
1. 아이디어 :
    백트래킹으로 풀었다가 효율이 안좋아서 정답을 확인했다
    for문안에서 각 단어 길이만큼의 슬라이딩 윈도우를 사용
2. 시간복잡도 :
    O(n*m)
3. 자료구조 :
    배열
'''

from collections import defaultdict

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []

        word_length = len(words[0])
        word_count = len(words)
        total_length = word_length * word_count
        word_map = defaultdict(int)
        for word in words:
            word_map[word] += 1

        ans = []

        for i in range(word_length):
            left = i
            right = i
            temp_map = defaultdict(int)
            count = 0

            while right + word_length <= len(s):
                word = s[right:right + word_length]
                right += word_length

                if word in word_map:
                    temp_map[word] += 1
                    count += 1

                    while temp_map[word] > word_map[word]:
                        left_word = s[left:left + word_length]
                        temp_map[left_word] -= 1
                        count -= 1
                        left += word_length
                        print(left_word, temp_map)

                    if count == word_count:
                        ans.append(left)
                else:
                    temp_map.clear()
                    count = 0
                    left = right

        return ans
