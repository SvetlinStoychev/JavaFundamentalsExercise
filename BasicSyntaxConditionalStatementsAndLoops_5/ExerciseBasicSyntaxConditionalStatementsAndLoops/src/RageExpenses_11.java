import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(reader.nextLine());
        double  headsetPrice = Double.parseDouble(reader.nextLine());
        double mousePrice = Double.parseDouble(reader.nextLine());
        double  keyboardPrice = Double.parseDouble(reader.nextLine());
        double displayPrice = Double.parseDouble(reader.nextLine());

        int headsetTrash = lostGamesCount / 2;
        int mouseTrash = lostGamesCount / 3;
        int keyboardTrash = lostGamesCount / 6;
        int displayTrash = lostGamesCount / 12;

        double totalPrice = (headsetPrice * headsetTrash) + (mousePrice * mouseTrash) +
                (keyboardPrice * keyboardTrash) + (displayPrice * displayTrash);

        System.out.printf("Rage expenses: %.2f lv.", totalPrice);
    }
}
