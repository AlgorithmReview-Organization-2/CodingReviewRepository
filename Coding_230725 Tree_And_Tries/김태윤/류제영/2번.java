# https://www.acmicpc.net/problem/14425

'''
1. 아이디어 :
    set으로 안에 있으면 answer++해줌
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    셋
'''

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            set.add(br.readLine());
        }

        int answer = 0;
        while (M-- > 0) {
            if(set.contains(br.readLine())) answer++;
        }

        System.out.println(answer);
    }
}
