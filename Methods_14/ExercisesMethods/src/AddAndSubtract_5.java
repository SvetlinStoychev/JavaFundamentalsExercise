import java.util.Scanner;

public class AddAndSubtract_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int first = Integer.parseInt(reader.nextLine());
        int second = Integer.parseInt(reader.nextLine());
        int third = Integer.parseInt(reader.nextLine());

        int sum = sum(first, second);
        System.out.println(subtract(sum, third));

    }
    public static int subtract(int sum, int third) {
        int result = sum - third;
        return result;
    }
    public static int sum(int first, int second) {
        int result = first + second;
        return result;
    }
}
