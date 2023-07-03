import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            numbers.add(rnd.nextInt(50));
        }

        Collections.sort(numbers);
        System.out.println(String.join(", ", numbers.toString()));
    }
}