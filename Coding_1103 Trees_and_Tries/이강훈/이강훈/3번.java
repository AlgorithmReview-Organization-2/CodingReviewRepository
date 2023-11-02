/*
https://www.acmicpc.net/problem/11437

아이디어
각 노드의 부모, 레벨(깊이) 기록, 비교 대상 간 깊이를 일치시키고 root 로 올라가며 값 일치 비교
 -> 위 방법 부모 , 레벨 기록을 입력받는대로 하니 입력 순서가 안맞는 경우 무한 대기 하는 듯 -> 검색해보고 트리 생성을 DFS 로 변경

자료구조
배열

시간복잡도
O( N * M ) // 최악 트리가 N 깊이까지 되고, findLCA 에서 모든 높이를 계속 탐색한 경우
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] depths;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        parents = new int[N + 1];
        depths = new int[N + 1];

        parents[1] = 1;
        depths[1] = 1;

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list.get(num1).add(num2);
            list.get(num2).add(num1);
        }

        dfs(1);

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(findLCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int node) {
        for (int adj : list.get(node)){
            if (parents[adj] == 0) {
                parents[adj] = node;
                depths[adj] = depths[node] + 1;
                dfs(adj);
            }
        }
    }

    public static int findLCA(int num1, int num2) {
        int num1Depth = depths[num1];
        int num2Depth = depths[num2];

        while (num1Depth > num2Depth) {
            num1 = parents[num1];
            num1Depth--;
        }

        while (num1Depth < num2Depth) {
            num2 = parents[num2];
            num2Depth--;
        }

        while (num1 != num2) {
            num1 = parents[num1];
            num2 = parents[num2];
        }

        return num1;
    }
}
