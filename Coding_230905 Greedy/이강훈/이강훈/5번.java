/*
https://www.acmicpc.net/problem/1082

아이디어
DP ( 각 비용의 최대값 활용 ) + 문자열 계산 어거지로 구현
.. 문제 매우 더럽다

자료구조
배열

시간복잡도
O(N * M)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numsLength = Integer.parseInt(br.readLine());

        int[] nums = new int[numsLength];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numsLength; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int money = Integer.parseInt(br.readLine());

        String[] dy = new String[money + 1];
        Arrays.fill(dy, "");
        for (int i = 1; i <= money; i++) {
            // 각 번호마다 이전 가능 비용 최대값을 참고해서 최대 값 계산
            for (int j = 0; j < numsLength; j++) {
                int beforeIndex = i - nums[j];

                if (beforeIndex < 0) continue;

                String newNum = calculateMax(dy[beforeIndex], String.valueOf(j).charAt(0));
                dy[i] = compare(dy[i], newNum);
            }
        }

        System.out.println(dy[money]);
    }

    public static String calculateMax(String orgNum, char num) {
        if (orgNum.equals("")) return String.valueOf(num);
        if (orgNum.equals("0") && num == '0') return "0";

        List<Character> list = new ArrayList<>();
        for (char c : orgNum.toCharArray()) {
            list.add(c);
        }

        list.add(num);

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder newNum = new StringBuilder();
        for (char c : list) {
            newNum.append(c);
        }

        return newNum.toString();
    }

    public static String compare(String str1, String str2) {
        if (str1.length() > str2.length()) return str1;
        else if (str1.length() < str2.length()) return str2;
        else {
            if (str1.compareTo(str2) > 0) return str1;
            else return str2;
        }
    }
}
