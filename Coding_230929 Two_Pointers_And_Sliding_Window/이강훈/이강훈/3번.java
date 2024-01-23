/*
https://www.acmicpc.net/problem/1644

아이디어
투 포인터

자료구조
ArrayList

시간복잡도
O(N log N) // 에라토스테네스의 체 소수 찾기 시간복잡도,, 소수 배수들을 모두 제거, 중복된 계산은 배제하여 소수 찾기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int L = 0;
        int R = 0;
        int total = 0;
        int answer = 0;
        while (true) {
            if (total < N) {
                if (R >= primes.size()) break;

                total += primes.get(R);
                R++;
            } else if (total > N) {
                total -= primes.get(L);
                L++;
            } else {
                answer++;

                total -= primes.get(L);
                L++;
            }
        }

        System.out.println(answer);
    }
}
