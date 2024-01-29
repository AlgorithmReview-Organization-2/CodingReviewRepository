import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] adj;
    static boolean[] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        int groupcnt = 0;
        vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i);
                groupcnt++;
            }
        }

        System.out.println((groupcnt - 1) + (m + groupcnt - 1) - (n - 1));
    }

    static void dfs(int cur) {
        if (vis[cur]) return;
        vis[cur] = true;
        for (int nxt : adj[cur]) {
            dfs(nxt);
        }
    }
}
