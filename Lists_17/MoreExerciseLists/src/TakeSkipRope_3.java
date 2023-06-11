import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<String> userInput = Arrays.stream(reader.nextLine().split(""))
                .collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < userInput.size(); i++) {
            char[] currentElementArr = userInput.get(i).toCharArray();
            char currentElement = currentElementArr[0];

            if (currentElement >= 48 && currentElement <= 57) {
                numbers.add(Integer.parseInt(String.valueOf(currentElement)));
                userInput.remove(i);
                i--;
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }

        int textIndex = 0;
        for (int i = 0; i < takeList.size(); i++) {
            int charCnt = takeList.get(i);
            int skipCnt = 0;
            for (int j = textIndex; j < textIndex + charCnt; j++) {
                if (j > userInput.size() - 1) {
                    break;
                }
                System.out.print(userInput.get(j));
                skipCnt++;
            }
            textIndex += skipList.get(i) + skipCnt;
        }
        System.out.println();
    }
}
