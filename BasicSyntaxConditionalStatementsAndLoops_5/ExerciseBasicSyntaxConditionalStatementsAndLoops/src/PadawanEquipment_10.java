import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(reader.nextLine());
        int  countOfStudents = Integer.parseInt(reader.nextLine());
        double priceOfLightsabers = Double.parseDouble(reader.nextLine());
        double  priceOfRobes = Double.parseDouble(reader.nextLine());
        double priceOfBelts = Double.parseDouble(reader.nextLine());

        double sabersAdditional = (countOfStudents * 10.0) / 100.0;
        int additionalSabersNum = (int)Math.ceil(sabersAdditional);
        int freeBelts = countOfStudents / 6;

        double totalPrice = (priceOfLightsabers * (countOfStudents + additionalSabersNum)) +
                (priceOfRobes * countOfStudents) + (priceOfBelts * (countOfStudents - freeBelts));

        if (amountOfMoney >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            double moneyNeed = totalPrice - amountOfMoney;
            System.out.printf("George Lucas will need %.2flv more.", moneyNeed);
        }
    }
}
