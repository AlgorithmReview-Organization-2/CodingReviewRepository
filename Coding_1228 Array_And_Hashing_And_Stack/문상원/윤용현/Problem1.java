import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class Problem1 {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] arr;
    static boolean escape = false;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        read();
        solve();
        write();
    }

    private static void write() {
        if (escape) {
            System.out.println("NO");
            return;
        }
        System.out.println(ans);
    }

    private static void solve() {
        int nxt = 1;
        for (int num : arr) {
            if (nxt <= num) {
                while (nxt <= num) {
                    stack.add(nxt++);
                    ans.append("+").append("\n");
                }
                stack.pop();
                ans.append("-").append("\n");

            } else {
                if (stack.isEmpty() || stack.peek() < num) {
                    escape = true;
                    return;

                } else if (!stack.isEmpty() && stack.peek() >= num) {
                    while (stack.peek() != num) {
                        stack.pop();
                        ans.append("-").append("\n");
                    }
                    ans.append("-").append("\n");
                    stack.pop();
                }
            }
        }
    }

    private static void read() {
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
