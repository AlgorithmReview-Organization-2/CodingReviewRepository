/*
https://leetcode.com/problems/house-robber-ii/description/

아이디어 ( 솔루션 보고 품 )
2차원 DP
 -> [start][end] 팰린드롬 가능 여부 저장
  -> 앞 자리부터 2중 for 문으로 팰린드롬 체크
   -> [start][end] 팰린드롬 조건은 charAt[start]==charAt[end] && ( end-start < 2 || [start+1][end-1]==true )

??
https://leetcode.com/problems/longest-palindromic-substring/solutions/4212564/beats-96-49-5-different-approaches-brute-force-eac-dp-ma-recursion/
Approach 4: Manacher's Algorithm
이건 O(N) 인데 무슨 방법인지..

자료구조
2차원 배열

시간복잡도
O (N^2)
*/

public class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dy = new boolean[s.length()][s.length()];

        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            dy[i][i] = true;

            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dy[j+1][i-1])) {
                    dy[j][i] = true;

                    if ((i - j) + 1 > maxLength) {
                        maxLength = (i - j) + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
