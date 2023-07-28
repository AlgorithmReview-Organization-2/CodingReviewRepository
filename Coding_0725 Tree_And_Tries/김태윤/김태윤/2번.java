## 문제

[실버3 문자열 집합](https://www.acmicpc.net/problem/14425)

1. 시간복잡도: O(N * L + M * L)
2. 아이디어: tries 구현 방법 그대로 사용
3. 자료구조: Tries
4. 메모: 메모리 너무 크다

## 코드
```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Main main = new Main();
        Trie trie = main.new Trie();
        
        // 문자열 집합을 Trie에 추가
        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        // 문자열과 일치하는 문자열
        for (int i = 0; i < M; i++) {
            if (trie.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }

    public class TrieNode {

        private Map<Character, TrieNode> childNodes = new HashMap<>();
        // 마지막 글자인지 여부
        private boolean isLastChar;

        //[Getter, Setter 메서드]
        // 자식 노드 맵 Getter
        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        // 마지막 글자인지 여부 Getter
        boolean isLastChar() {
            return this.isLastChar;
        }

        // 마지막 글자인지 여부 Setter
        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }

    }


    public class Trie {
        // [변수]
        // 루트 노드
        private TrieNode rootNode;

        // [생성자]
        Trie() {
            rootNode = new TrieNode();
        }

        // 자식 노드 추가
        void insert(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
        }

        // 특정 단어가 들어있는지 확인
        boolean contains(String word) {
            TrieNode thisNode = this.rootNode;

            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(character);
                if (node == null) {
                    return false;
                }
                thisNode = node;
            }
            return thisNode.isLastChar();
        }
    }

}
```
