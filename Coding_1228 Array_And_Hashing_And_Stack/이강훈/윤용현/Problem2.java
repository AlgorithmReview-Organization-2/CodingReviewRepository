import java.util.ArrayDeque;
import java.util.Queue;

public class Problem2 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;
        int curWeight = 0;
        Queue<Truck> bridge = new ArrayDeque<>();

        while (true) {
            time++;

            if (!bridge.isEmpty() && time - bridge.peek().inTime >= bridge_length) {
                Truck poll = bridge.poll();
                curWeight -= poll.weight;
            }

            if (idx == truck_weights.length && bridge.isEmpty()) {
                break;
            }

            if (idx < truck_weights.length && curWeight + truck_weights[idx] <= weight) {
                bridge.add(new Truck(truck_weights[idx], time));
                curWeight += truck_weights[idx];
                idx++;
            }
        }

        return time;
    }

    static class Truck {
        int weight;
        int inTime;

        public Truck(int weight, int inTime) {
            this.weight = weight;
            this.inTime = inTime;
        }
    }
}

