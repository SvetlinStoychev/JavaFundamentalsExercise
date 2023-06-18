import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] carsArr = reader.nextLine().split(">>");

        double totalTaxIncome = 0;

        for (int i = 0; i < carsArr.length; i++) {
            String[] currentCarInfo = carsArr[i].split(" ");
            String carType = currentCarInfo[0];
            int years = Integer.parseInt(currentCarInfo[1]);
            int kilometers = Integer.parseInt(currentCarInfo[2]);

            switch (carType) {
                case "family":
                    double declineForYear = years * 5;
                    int increasesForKm = kilometers / 3000;
                    double increasesTax = increasesForKm * 12;
                    double tax = (50 - declineForYear) + increasesTax;
                    totalTaxIncome += tax;
                    System.out.printf("A family car will pay %.2f euros in taxes.%n", tax);
                    break;
                case "heavyDuty":
                    declineForYear = years * 8;
                    increasesForKm = kilometers / 9000;
                    increasesTax = increasesForKm * 14;
                    tax = (80 - declineForYear) + increasesTax;
                    totalTaxIncome += tax;
                    System.out.printf("A heavyDuty car will pay %.2f euros in taxes.%n", tax);
                    break;
                case "sports":
                    declineForYear = years * 9;
                    increasesForKm = kilometers / 2000;
                    increasesTax = increasesForKm * 18;
                    tax = (100 - declineForYear) + increasesTax;
                    totalTaxIncome += tax;
                    System.out.printf("A sports car will pay %.2f euros in taxes.%n", tax);
                    break;
                default:
                    System.out.println("Invalid car type.");
                    break;
            }
        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTaxIncome);
    }
}
