import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<String> userInput = Arrays.stream(reader.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        for (int i = userInput.size() - 1; i >= 0 ; i--) {
            String currentListAsStr = userInput.get(i);
            String[] currentArr = currentListAsStr.split("\\s+");
            for (int j = 0; j < currentArr.length; j++) {

                if (!currentArr[j].equals("")) {
                    currentList.add(Integer.parseInt(currentArr[j]));
                }
            }

            resultList.addAll(currentList);
            currentList.clear();
        }

        System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
    }
}
