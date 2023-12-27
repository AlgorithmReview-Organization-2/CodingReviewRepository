/*
https://www.acmicpc.net/problem/1744

아이디어
정렬 후
 -> 음수는 가장 작은 값부터 0까지 무조건 곱이 이득
 -> 양수는 큰수부터 덧셈, 곱 중 큰 값 적용

자료구조
배열

시간복잡도
O ( N log N )
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (N-- > 0) {
            list.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(list);

        int answer = 0;

        int before = 0;
        int index = 0;
        while (index < list.size() && list.get(index) <= 0) {
            if (before == 0) {
                before = list.get(index);
            } else {
                answer += (before * list.get(index));
                before = 0;
            }

            index++;
        }

        answer += before;

        before = 0;
        index = list.size() - 1;
        while (index >= 0 && list.get(index) > 0) {
            if (before == 0) {
                before = list.get(index);
            } else {
                answer += Math.max(before + list.get(index), before * list.get(index));
                before = 0;
            }

            index--;
        }

        System.out.println(answer + before);
    }
}
