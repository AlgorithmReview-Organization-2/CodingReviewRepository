/*
https://www.acmicpc.net/problem/12865

아이디어
무게를 기준으로 최선의 Value 를 DP
-> 모든 경우 중 가장 큰 값이 정답
--> 실패 -> 물건을 한 번 밖에 못씀
---> (아이디어 검색) 2차원 배열로 최선의 가치 찾기
---> weight -> K 반복 & ( index -> N 반복 = 각 weight 별로 이전 노드의 계산과 자기 노드 가치 추가의 경우에서 최선을 계산 )
[ 어렵다.. ]

자료구조
배열
--> 수정 ( 2차원 배열 )

시간복잡도
O(N * K)
--> 수정 O( N * K )
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] dy = new int[N + 1][K + 1];
        for (int weightIndex = 0; weightIndex < K + 1; weightIndex++) {
            for (int nodeIndex = 1; nodeIndex < N + 1; nodeIndex++) {
                int beforeWeight = weightIndex - nodes[nodeIndex].weight;

                if (beforeWeight < 0) dy[nodeIndex][weightIndex] = dy[nodeIndex - 1][weightIndex];
                else
                    dy[nodeIndex][weightIndex] = Math.max(dy[nodeIndex - 1][weightIndex], dy[nodeIndex - 1][beforeWeight] + nodes[nodeIndex].value);
            }
        }

        System.out.println(dy[N][K]);
    }
}

class Node {
    int weight;
    int value;

    public Node(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
