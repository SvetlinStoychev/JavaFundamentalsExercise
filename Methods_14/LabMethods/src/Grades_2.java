import java.util.Scanner;

public class Grades_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double inputGrade = Double.parseDouble(reader.nextLine());

        printGradeInWords(inputGrade);
    }

    public static void printGradeInWords(double grade) {
        String resultGrade = "";
        if (grade >= 2.0 && grade <= 2.99) {
            resultGrade = "Fail";
        } else if (grade >= 3.0 && grade <= 3.49) {
            resultGrade = "Poor";
        } else if (grade >= 3.5 && grade <= 4.49) {
            resultGrade = "Good";
        } else if (grade >= 4.5 && grade <= 5.49) {
            resultGrade = "Very good";
        } else {
            resultGrade = "Excellent";
        }
        System.out.println(resultGrade);
    }
}
