import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> firstList = Arrays
                .stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays
                .stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int minSize = Math.min(firstList.size(), secondList.size());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < minSize; i++) {
            int firstNum = firstList.get(i);
            int secondNum = secondList.get(i);

            result.add(firstNum);
            result.add(secondNum);
        }

        if (firstList.size() > secondList.size()) {
            List<Integer> firstSubList = firstList.subList(minSize, firstList.size());
            result.addAll(firstSubList);
        } else if (secondList.size() > firstList.size()) {
            List<Integer> secondSubList = secondList.subList(minSize, secondList.size());
            result.addAll(secondSubList);
        }

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
