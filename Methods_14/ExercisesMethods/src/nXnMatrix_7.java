import java.util.Scanner;

public class nXnMatrix_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        printsMatrix(n);
    }

    public static void printsMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
