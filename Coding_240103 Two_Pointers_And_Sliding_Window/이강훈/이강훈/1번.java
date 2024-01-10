/*
https://www.acmicpc.net/problem/15961 ( 최대한 많은 종류 초밥 먹기 )

아이디어
슬라이딩 윈도우, HashMap 으로 초밥 종류 카운트 ( key 수 ) 후 쿠폰 초밥 종류 카운트 안되었으면 무료 1개 추가

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
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + k];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            nums[N + i] = nums[i];
        }

        Map<Integer, Integer> map = new HashMap<>();

        int answer = 0;
        int couponCount = 0;
        int left = 0;
        int right = 0;
        while (left < N) {
            while (right < left + k) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

                if (nums[right++] == c) couponCount++;
            }
            answer = Math.max(answer, couponCount > 0 ? map.size() : map.size() + 1);

            map.put(nums[left], map.get(nums[left]) - 1);

            if (map.get(nums[left]) == 0) map.remove(nums[left]);
            if (nums[left++] == c) couponCount--;
        }

        System.out.println(answer);
    }
}
