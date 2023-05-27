import java.util.Scanner;

public class Train_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int wagonCnt = Integer.parseInt(reader.nextLine());

        int[] passengerNum = new int[wagonCnt];
        for (int i = 0; i < passengerNum.length; i++) {
            passengerNum[i] = Integer.parseInt(reader.nextLine());
        }

        int sum = 0;
        for (int i = 0; i < passengerNum.length; i++) {
            sum += passengerNum[i];
            System.out.printf("%d ", passengerNum[i]);
        }

        System.out.printf("%n%d", sum);
    }
}
