import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());

        for (int i = 1; i <= n ; i++) {

            if ((i % 5 == 0) && (i % 7 == 0)) {
                System.out.println("FooBar");
            } else if (i % 7 == 0) {
                System.out.println("Bar");
            } else if (i % 5 == 0) {
                System.out.println("Foo");
            } else {
                System.out.println(i);
            }
        }
    }
}