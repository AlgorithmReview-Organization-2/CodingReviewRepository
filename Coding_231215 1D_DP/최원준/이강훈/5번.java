/*
https://leetcode.com/problems/decode-ways/description/

아이디어 ( 솔루션 보고 품 )
 ( 근데 점화식이 이해가 안댐, 왜 2개 1개 경우의 수가 합쳐지는거지..? )
 정답보고 품..

자료구조
배열

시간복잡도
O ( N )
*/

public class Solution {
    public int numDecodings(String s) {
        int[] dy = new int[s.length() + 1];

        dy[0] = 1;
        dy[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int useOne = Integer.parseInt(s.substring(i - 1, i));
            if (useOne != 0) dy[i] += dy[i-1];

            int useTwo = Integer.parseInt(s.substring(i - 2, i));
            if (useTwo >= 10 && useTwo <= 26 ) dy[i] += dy[i-2];
        }

        return dy[s.length()];
    }
}
