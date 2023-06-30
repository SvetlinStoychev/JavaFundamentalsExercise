import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Courses_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();
        LinkedHashMap<String, ArrayList<String>> courseMap = new LinkedHashMap<>();

        while (!command.equals("end")) {
            String[] commandArr = command.split(" : ");
            String courseName = commandArr[0];
            String studentName = commandArr[1];

            if (courseMap.containsKey(courseName)) {
                ArrayList<String> currentStudentList = courseMap.get(courseName);
                currentStudentList.add(studentName);
                courseMap.put(courseName, currentStudentList);
            } else {
                ArrayList<String> nextStudentList = new ArrayList<>();
                nextStudentList.add(studentName);
                courseMap.put(courseName, nextStudentList);
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : courseMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();

            System.out.printf("%s: %d%n", key, value.size());

            for (String student : value) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
