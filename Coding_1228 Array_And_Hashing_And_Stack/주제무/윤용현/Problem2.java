import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class Problem2 {

    static Map<String, Integer> complaintSum = new HashMap<>();
    static Map<String, Set<String>> complainNames = new HashMap<>();

    public static int[] solution(String[] id_list, String[] report, int k) {
        init(id_list);
        countComplain(report);
        return sendResultMail(id_list, k);
    }

    private static int[] sendResultMail(String[] id_list, int k) {
        int[] ret = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            for (String to : complainNames.get(id_list[i])) {
                if (complaintSum.get(to) >= k) {
                    cnt++;
                }
            }
            ret[i] = cnt;
        }

        for (int i : ret) {
            System.out.println(i);
        }

        return ret;
    }

    private static void countComplain(String[] report) {
        for (String element : report) {
            String[] arr = element.split(" ");
            String from = arr[0];
            String to = arr[1];

            if (!complainNames.get(from).contains(to)) {
                complaintSum.put(to, complaintSum.get(to) + 1);
                complainNames.get(from).add(to);
            }
        }
    }

    public static void init(String[] id_list) {
        for (String id : id_list) {
            complaintSum.put(id, 0);
            complainNames.put(id, new HashSet());
        }
    }
}
