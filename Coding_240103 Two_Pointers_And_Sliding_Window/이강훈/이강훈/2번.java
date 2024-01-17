/*
https://www.acmicpc.net/problem/16472

아이디어
투 포인터, HashMap 카운트 ( 효율적인 방법은 아닌듯, 간단하게 될 것 같은데 )
 -> N 만큼 종류 최대한 길게 right 보내고 계산 후 1 종류 제거를 위해 left 끌고옴

자료구조
HashMap

시간복잡도
O ( N )
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int answer = 0;
        while (left < str.length()) {
            while (right < str.length()) {
                if (map.size() == N && !map.containsKey(str.charAt(right))) break;

                map.put(str.charAt(right), map.getOrDefault(str.charAt(right++), 0) + 1);
            }
            answer = Math.max(answer, right - left);

            while (map.get(str.charAt(left)) != 1) {
                map.put(str.charAt(left), map.get(str.charAt(left++)) - 1);
            }
            map.remove(str.charAt(left++));
        }

        System.out.println(answer);
    }
}
