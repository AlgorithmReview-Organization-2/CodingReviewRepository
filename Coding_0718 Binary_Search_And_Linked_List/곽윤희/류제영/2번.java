# https://www.acmicpc.net/problem/1406

'''
1. 아이디어 :
    그냥 링크드리스트로 해서 하니깐 시간초과가 뜸, ListIterator를 사용
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    링크드리스트
'''

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> linkedList = new LinkedList<>();
        char[] charArray = br.readLine().toCharArray();
        for (char c : charArray) {
            linkedList.add(c);
        }

        ListIterator<Character> iter = linkedList.listIterator();
        while (iter.hasNext()) {
            iter.next();
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L") && iter.hasPrevious()) iter.previous();

            if (command.equals("D") && iter.hasNext()) iter.next();

            if (command.equals("B") && iter.hasPrevious()) {
                iter.previous();
                iter.remove();
            }

            if (command.equals("P")) iter.add(st.nextToken().charAt(0));
        }

        for (Character character : linkedList) {
            bw.write(character);
        }

        bw.flush();
    }
}
