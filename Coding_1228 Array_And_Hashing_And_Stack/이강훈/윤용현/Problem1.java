import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Problem1 {

    public boolean solution(String[] phone_book) {
        Set<String> phonebooks = Arrays.stream(phone_book).collect(Collectors.toSet());

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phonebooks.contains(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
