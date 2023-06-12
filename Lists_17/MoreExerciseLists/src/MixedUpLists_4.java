import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> firstNumbersList = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondNumbersList = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mixedList = new ArrayList<>();
        int secondListLastIndex = secondNumbersList.size() - 1;
        int firstConstrain = Integer.MIN_VALUE;
        int secondConstrain = Integer.MIN_VALUE;

        for (int i = 0; i < firstNumbersList.size(); i++) {

            if (secondListLastIndex < 0) {
                firstConstrain = firstNumbersList.get(firstNumbersList.size() - 2);
                secondConstrain = firstNumbersList.get(firstNumbersList.size() - 1);
                break;
            }

            mixedList.add(firstNumbersList.get(i));
            mixedList.add(secondNumbersList.get(secondListLastIndex));
            secondListLastIndex--;
        }

        if (firstConstrain == Integer.MIN_VALUE && secondConstrain == Integer.MIN_VALUE) {
            firstConstrain = secondNumbersList.get(0);
            secondConstrain = secondNumbersList.get(1);
        }

        if (firstConstrain > secondConstrain) {
            int temp = firstConstrain;
            firstConstrain = secondConstrain;
            secondConstrain = temp;
        }

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < mixedList.size(); i++) {

            if (mixedList.get(i) > firstConstrain && mixedList.get(i) < secondConstrain) {
                resultList.add(mixedList.get(i));
            }
        }

        Collections.sort(resultList);

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
