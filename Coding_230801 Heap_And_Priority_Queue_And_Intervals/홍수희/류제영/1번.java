# https://leetcode.com/problems/sort-characters-by-frequency/

'''
1. 아이디어 :
    1. Map을 사용하여 키에 단어와 값에 단어가 등장하는 수를 넣어줌
    2. 우선순위 큐를 Map을 이용하여 정렬함
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    우선순위 큐
'''

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (Character character : map.keySet()) {
            queue.offer(character);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char temp = queue.poll();

            for (int i = 0; i < map.get(temp); i++) {
                sb.append(temp);
            }
        }

        return sb.toString();
    }
}
