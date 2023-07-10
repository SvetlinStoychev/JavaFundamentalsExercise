import java.util.Scanner;

public class StringExplosion_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        char[] inputArr = input.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputArr.length; i++) {

            if (inputArr[i] == '>') {
                int strength = Integer.parseInt(Character.toString(inputArr[i+1]));
                result.append(inputArr[i]);
                int position = 0;

                for (int j = i + 1; j <= strength + i; j++) {

                    if (j >= inputArr.length - 1) {
                        position++;
                        break;
                    }
                    if (inputArr[j] == '>') {
                        strength++;
                        strength += Integer.parseInt(Character.toString(inputArr[j + 1]));
                        result.append('>');

                    }

                    position = j;
                }

                i = position;
            } else {
                result.append(inputArr[i]);
            }
        }

        System.out.println(result);
    }
}
