/*
https://www.acmicpc.net/problem/1041

아이디어
N=1 제외하면 사용되는 면은 3개 , 2개 , 1개 경우 밖에 없음
 -> 절대 붙을 수 없는 경우를 제외한 최소값을 계산

자료구조
배열

시간복잡도
O(1)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(Math.min(dice[0], dice[5]));
        list.add(Math.min(dice[1], dice[4]));
        list.add(Math.min(dice[2], dice[3]));

        Collections.sort(list);
        long useThree = list.get(0) + list.get(1) + list.get(2);
        long useTwo = list.get(0) + list.get(1);
        long useOne = list.get(0);

        if (N == 1) {
            Arrays.sort(dice);

            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        } else {
            long answer = 0;
            // 3면이 사용되는 경우는 주사위 윗면의 각 모서리
            answer += useThree * 4L;
            // 2면이 사용되는 경우는 4개 기둥 + 윗면의 4개 사이드
            answer += useTwo * 4L * (N - 1) + useTwo * 4L * (N - 2);
            // 1면 사용되는건 나머지
            answer += useOne * (N - 2) * (N - 1) * 4L + useOne * (N - 2) * (N - 2);

            System.out.println(answer);
        }
    }
}
