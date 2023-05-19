import java.util.Scanner;

public class Vacation_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int numberPeople = Integer.parseInt(reader.nextLine());
        String typePeople = reader.nextLine();
        String day = reader.nextLine();

        double singlePrice = 0.0;
        if (day.equals("Friday")) {
            if (typePeople.equals("Students")) {
                singlePrice = 8.45;
            } else if (typePeople.equals("Business")) {
                singlePrice = 10.90;
            } else if (typePeople.equals("Regular")) {
                singlePrice = 15.0;
            }
        } else if (day.equals("Saturday")) {
            if (typePeople.equals("Students")) {
                singlePrice = 9.80;
            } else if (typePeople.equals("Business")) {
                singlePrice = 15.60;
            } else if (typePeople.equals("Regular")) {
                singlePrice = 20.0;
            }
        } else if (day.equals("Sunday")) {
            if (typePeople.equals("Students")) {
                singlePrice = 10.46;
            } else if (typePeople.equals("Business")) {
                singlePrice = 16.0;
            } else if (typePeople.equals("Regular")) {
                singlePrice = 22.50;
            }
        }

        double totalPrice = 0.0;
        double discount = 0.0;
        if (typePeople.equals("Students")) {
            totalPrice = singlePrice * numberPeople;
            if (numberPeople >= 30) {
                discount = (totalPrice * 15) / 100;
                totalPrice = totalPrice - discount;
            }
        } else if (typePeople.equals("Business")) {
            totalPrice = singlePrice * numberPeople;
            if (numberPeople >= 100) {
                discount = singlePrice * 10;
                totalPrice = totalPrice - discount;
            }
        } else if (typePeople.equals("Regular")) {
            totalPrice = singlePrice * numberPeople;
            if (numberPeople >= 10 && numberPeople <= 20) {
                discount = (totalPrice * 5) / 100;
                totalPrice = totalPrice - discount;
            }
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
