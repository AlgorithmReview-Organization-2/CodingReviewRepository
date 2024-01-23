/*
https://www.acmicpc.net/problem/1918

아이디어
구현 방법이 생각 안남
-> 아이디어 검색 -> 연산자의 우선순위, ( 곱, 나눗셈은 덧셈, 뺄셈보다 빨리 나와야함 [ 그보다 괄호가 더 우선 ] )  ( 후위 표현 전용 ? )

자료구조
스택

시간복잡도
O(N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Stack<Character> operatorStack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (operatorStack.peek() != '(') {
                    sb.append(operatorStack.pop());
                }
                // 여는 괄호 빼주기
                operatorStack.pop();
            } else if (c == '(') {
                // 괄호 시작점 표시
                operatorStack.push(c);
            } else if (c == '*' || c == '/') {
                // 곱셈, 나눗셈은 덧셈 뺄셈보다 빠르게 나와야함
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    sb.append(operatorStack.pop());
                }
                operatorStack.push(c);
            } else if (c == '+' || c == '-') {
                // 덧셈, 뺼셈은 항상 앞에 연산이 우선 수행
                while (!operatorStack.isEmpty() && !(operatorStack.peek() == '(')) {
                    sb.append(operatorStack.pop());
                }
                operatorStack.push(c);
            } else {
                sb.append(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop());
        }

        System.out.println(sb);
    }
}
