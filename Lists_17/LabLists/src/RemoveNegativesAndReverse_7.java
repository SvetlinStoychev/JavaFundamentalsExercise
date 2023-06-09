import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> numbersList = Arrays
                .stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbersList.removeIf(e -> e < 0);
        Collections.reverse(numbersList);

        if (numbersList.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
