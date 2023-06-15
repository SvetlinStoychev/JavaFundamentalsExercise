import java.util.Scanner;

public class Reception_2_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(reader.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(reader.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(reader.nextLine());

        int studentsCount = Integer.parseInt(reader.nextLine());

        int totalEfficiency = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        int hourCnt = 0;
        int breakHour = 3;

        while (studentsCount > 0) {

            if (hourCnt == breakHour) {
                hourCnt++;
                breakHour = hourCnt + 3;
            } else {
                hourCnt++;
                studentsCount -= totalEfficiency;
            }
        }

        System.out.printf("Time needed: %dh.", hourCnt);
    }
}
