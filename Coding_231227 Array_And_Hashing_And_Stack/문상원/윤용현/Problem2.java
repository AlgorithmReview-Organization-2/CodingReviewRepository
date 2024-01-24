import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// https://www.acmicpc.net/problem/17298
public class Problem2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static int[] ans;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        read();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int n : ans) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
    }

    private static void read() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = new int[N];
        Arrays.fill(ans, -1);
    }
}
