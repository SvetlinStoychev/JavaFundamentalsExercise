import java.util.Scanner;

public class CalculateRectangleArea_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int inputWidth = Integer.parseInt(reader.nextLine());
        int inputHeight = Integer.parseInt(reader.nextLine());

        int rectangleArea = calculateArea(inputWidth, inputHeight);
        System.out.println(rectangleArea);
    }

    public static int calculateArea(int width, int height) {
        return width * height;
    }
}
