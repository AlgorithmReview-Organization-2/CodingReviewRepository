/*
https://leetcode.com/problems/distinct-subsequences/description/

아이디어
모르겟어서 정답확인
 -> https://leetcode.com/problems/distinct-subsequences/solutions/37327/easy-to-understand-dp-in-java/

자료구조
배열

시간복잡도
O (nm)
*/

import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dy = new int[t.length() + 1][s.length() + 1];

        Arrays.fill(dy[0], 1);

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dy[i + 1][j + 1] = dy[i][j] + dy[i+1][j];
                }
                else {
                    dy[i + 1][j + 1] = dy[i+1][j];
                }
            }
        }

        return dy[t.length()][s.length()];
    }
}
