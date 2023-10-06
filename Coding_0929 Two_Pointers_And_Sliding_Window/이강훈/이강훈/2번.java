/*
https://www.acmicpc.net/problem/2096

아이디어
구현

자료구조
배열

시간복잡도
O(N)
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maxValue = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] minValue = maxValue.clone();

        while (N-- > 1) {
            st = new StringTokenizer(br.readLine());
            int[] currentValue = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] tempMaxValue = maxValue.clone();
            int[] tempMinValue = minValue.clone();

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    maxValue[i] = Math.max(tempMaxValue[i] + currentValue[i], tempMaxValue[i + 1] + currentValue[i]);

                    minValue[i] = Math.min(tempMinValue[i] + currentValue[i], tempMinValue[i + 1] + currentValue[i]);
                } else if (i == 1) {
                    maxValue[i] = Math.max(tempMaxValue[i - 1] + currentValue[i], tempMaxValue[i] + currentValue[i]);
                    maxValue[i] = Math.max(maxValue[i], tempMaxValue[i + 1] + currentValue[i]);

                    minValue[i] = Math.min(tempMinValue[i - 1] + currentValue[i], tempMinValue[i] + currentValue[i]);
                    minValue[i] = Math.min(minValue[i], tempMinValue[i + 1] + currentValue[i]);
                } else {
                    maxValue[i] = Math.max(tempMaxValue[i] + currentValue[i], tempMaxValue[i - 1] + currentValue[i]);

                    minValue[i] = Math.min(tempMinValue[i] + currentValue[i], tempMinValue[i - 1] + currentValue[i]);
                }
            }
        }

        System.out.println(Arrays.stream(maxValue).asLongStream().max().getAsLong() + " " + Arrays.stream(minValue).asLongStream().min().getAsLong());
    }
}
