/*
https://www.acmicpc.net/problem/11000

아이디어
강의 ( 시작 - 끝 시간 ) 자체를 시작 시간 오름차순 정렬
강의장 ( 각 강의장의 끝나는 시간을 저장 ) 끝 시간 오름차순 정렬
 -> 강의 하나씩 꺼내면서 강의장 가장 빨리 끝나는 시간이 강의 시작 시간보다 작거나 같으면 대체 , 아니면 강의장 추가

자료구조
Priority Queue

시간복잡도
O (N log N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pqRoom = new PriorityQueue<>();
        Queue<Subject> pqSubject = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            pqSubject.add(new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!pqSubject.isEmpty()) {
            Subject subject = pqSubject.poll();

            if (pqRoom.isEmpty()){
                pqRoom.add(subject.end);
            } else {
                int shortestEnd = pqRoom.poll();

                if (subject.start >= shortestEnd) pqRoom.add(subject.end);
                else {
                    pqRoom.add(shortestEnd);
                    pqRoom.add(subject.end);
                }
            }
        }

        System.out.println(pqRoom.size());
    }
}

class Subject implements Comparable<Subject> {
    int start;
    int end;

    public Subject(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Subject o) {
        return this.start - o.start;
    }
}
