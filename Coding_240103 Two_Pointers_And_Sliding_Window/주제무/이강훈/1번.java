/*
https://www.acmicpc.net/problem/2428

아이디어
정렬, 투포인터
 -> left 0 -> length 이동, 각 left 에서 right 를 최대한 밀기

자료구조
비열

시간복잡도
O (N log N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        int answer = 0;
        while (left < N) {
            while (right < N && nums[left] * 10 >= nums[right] * 9) {
                right++;
            }

            answer += right - left - 1;
            left++;
        }

        System.out.println(Math.max(answer, 0));
    }
}
