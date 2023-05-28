import java.util.Scanner;

public class PascalTriangle_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int[][] pascalTriangle = new int[n][];

        for (int i = 0; i < n; i++) {

            pascalTriangle[i] = new int[i + 1];

            pascalTriangle[i][0] = 1;

            for (int j = 1; j < i; j++) {

                pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];

            }
            
            pascalTriangle[i][i] = 1;

        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i ; j++) {
                System.out.printf("%d ", pascalTriangle[i][j]);
            }

            System.out.println();

        }

    }
}
