import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 여행가자 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int city = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[city + 1][city + 1];

		int PlanCity = Integer.parseInt(br.readLine());
		for (int i = 1; i < city + 1; i++) {
			String[] po = br.readLine().split(" ");
			for (int j = 1; j < city + 1; j++) {
				if (Integer.parseInt(po[j - 1]) == 1) {
					visit[i][j] = true;
					visit[j][i] = true;
				}
			}
		}
		String[] p = br.readLine().split(" ");
		int s = 0;
		for (int i = 0; i < p.length - 1; i++) {
			boolean visited[] = new boolean[city + 1]; // 방문 여부를 검사할 배열
			if (Integer.parseInt(p[i]) == Integer.parseInt(p[i + 1])) {
				continue;
			}
			if (!visit[Integer.parseInt(p[i])][Integer.parseInt(p[i + 1])]) {
				// 만약 직접적으로 이어져있지않다면
				// bfs로 연결자체는 되어있는지 확인한다.
				// 만약 연결이 안되어있다면 여행불가 판정
				if (!bfs(Integer.parseInt(p[i]), Integer.parseInt(p[i + 1]), visit, visited)) {
					s++;
					break;
				}
			} else {

			}
		}
		if (s == 0) {
			System.out.println("YES");
		} else
			System.out.println("NO");
	}

	public static boolean bfs(int v, int d, boolean[][] adj, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		int n = adj.length - 1;

		q.add(v);
		visited[v] = true;
		//System.out.println(v+"와"+d+"가 연결돼있는지 확인");
		while (!q.isEmpty()) {
			v = q.poll();
			if (v == d) {
				//System.out.println("연결 확인");
				return true;
			}
			for (int i = 1; i < n + 1; i++) {
				if (adj[v][i] == true && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		return false;
	}

}
