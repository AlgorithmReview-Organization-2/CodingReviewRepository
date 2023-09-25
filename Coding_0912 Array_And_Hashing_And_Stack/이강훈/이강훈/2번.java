/*
https://www.acmicpc.net/problem/2002

아이디어
Hashmap 순서 기록 -> 기록보다 들어온 순서가 작으면 추월
 -> 안돌려봐도 이상해서 로직 수정 -> 투포인터

자료구조
배열

시간복잡도
O(N^2)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> startList = new ArrayList<>();
        List<String> endList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            startList.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            endList.add(br.readLine());
        }

        int startIndex = 0;
        int endIndex = 0;
        int answer = 0;

        while (endIndex < endList.size()) {
            if (startList.get(startIndex).equals(endList.get(endIndex))) startIndex++;
            else {
                startList.remove(endList.get(endIndex));
                answer++;
            }

            endIndex++;
        }

        System.out.println(answer);
    }
}
