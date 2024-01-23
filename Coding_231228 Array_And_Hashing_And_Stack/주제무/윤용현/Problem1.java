import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/2800
public class Problem1 {

    static Scanner sc = new Scanner(System.in);
    static String inputStr;
    static boolean[] vis;
    static Map<Integer, Integer> pair = new HashMap<>();
    static Set<String> ans = new HashSet<>();

    public static void main(String[] args) {
        init();
        dfs("", 0);
        write();
    }

    private static void write() {
        StringBuilder sb = new StringBuilder();
        for (String str : ans.stream().sorted().collect(Collectors.toList())) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() {
        inputStr = sc.next();
        vis = new boolean[inputStr.length()];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == '(') {
                stack.push(i);
            } else if (inputStr.charAt(i) == ')') {
                pair.put(i, stack.pop());
            }
        }
    }

    static void dfs(String str, int idx) {
        if (idx == inputStr.length()) {
            if (!str.equals(inputStr)) {
                ans.add(str);
            }
            return;
        }

        if (inputStr.charAt(idx) == '(') {
            vis[idx] = true;
            dfs(str + "(", idx + 1);
            vis[idx] = false;
            dfs(str, idx + 1);

        } else if (inputStr.charAt(idx) == ')') {
            if (vis[pair.get(idx)]) {
                dfs(str + ")", idx + 1);
            } else {
                dfs(str, idx + 1);
            }


        } else {
            dfs(str + inputStr.charAt(idx), idx + 1);
        }

    }
}
