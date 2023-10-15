/*
https://www.acmicpc.net/problem/1522

아이디어
접근이 잘못되어서 슬라이딩 윈도우 아이디어 찾아보고 변경
-> a 의 수가 결국 연속이어야 하므로 a 의 수를 슬라이딩 윈도우 크기로 두고 b의 수 카운트 -> 최소 b 수가 정답

자료구조
변수

시간복잡도
O(N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int aCount = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a') aCount++;
        }

        int l = 0;
        int r = 0;
        int bCount = 0;
        while (r < l + aCount) {
            if (str.charAt(r++) == 'b') bCount++;
        }

        if (r == str.length()) r = 0;

        int minBCount = bCount;

        for (; l < str.length(); l++) {
            if (str.charAt(l) == 'b') bCount--;
            if (str.charAt(r) == 'b') bCount++;

            r = r + 1 == str.length() ? 0 : r + 1;

            minBCount = Math.min(minBCount, bCount);
        }

        System.out.println(minBCount);
    }
}
