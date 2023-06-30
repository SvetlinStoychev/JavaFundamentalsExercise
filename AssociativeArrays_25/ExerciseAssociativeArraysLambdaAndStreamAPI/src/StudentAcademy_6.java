import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, Double[]> gradeMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.nextLine();
            double grade = Double.parseDouble(reader.nextLine());

            if (gradeMap.containsKey(name)) {
                Double[] currentGrade = gradeMap.get(name);
                currentGrade[0] += grade;
                currentGrade[1] += 1;
                gradeMap.put(name, currentGrade);
            } else {
                Double[] gradeArr = new Double[2];
                gradeArr[0] = grade;
                gradeArr[1] = 1.0;
                gradeMap.put(name, gradeArr);
            }
        }

        for (Map.Entry<String, Double[]> entry : gradeMap.entrySet()) {
            String name = entry.getKey();
            double average = entry.getValue()[0] / entry.getValue()[1];

            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n", name, average);
            }
        }
    }
}
