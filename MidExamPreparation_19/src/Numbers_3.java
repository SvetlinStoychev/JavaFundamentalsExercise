import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> numbersSequence = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        for (int i = 0; i < numbersSequence.size(); i++) {
            sum += numbersSequence.get(i);
        }

        double average = sum * 1.0 / numbersSequence.size();

        Collections.sort(numbersSequence);

        int sequenceCnt = 0;
        for (int i = numbersSequence.size() - 1; i >= 0; i--) {
            if (numbersSequence.get(i) > average) {
                System.out.printf("%d ", numbersSequence.get(i));
                sequenceCnt++;
            }

            if (sequenceCnt >= 5) {
                break;
            }
        }

        if (sequenceCnt == 0) {
            System.out.println("No");
        }
    }
}
