import java.util.Scanner;

public class Students_4 {
    public static class Student {
        private String firstName;
        private String lastName;
        private Double grade;

        public Student(String fName, String lName, Double grade) {
            this.firstName = fName;
            this.lastName = lName;
            this.grade = grade;
        }
        public String getFirstName() {
            return this.firstName;
        }
        public String getLastName() {
            return this.lastName;
        }
        public Double getGrade() {
            return this.grade;
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        Student[] studentsArr = new Student[n];

        for (int i = 0; i < n; i++) {
            String[] studentDataArr = reader.nextLine().split(" ");
            String fName = studentDataArr[0];
            String lName = studentDataArr[1];
            double grade = Double.parseDouble(studentDataArr[2]);

            Student currentStudent = new Student(fName, lName, grade);
            studentsArr[i] = currentStudent;
        }

        Student[] orderedStudentArr = orderStudentsByGrade(studentsArr);

        for (int i = 0; i < orderedStudentArr.length; i++) {
            System.out.printf("%s %s: %.2f%n", orderedStudentArr[i].getFirstName()
            , orderedStudentArr[i].getLastName(), orderedStudentArr[i].getGrade());
        }
    }
    public static Student[] orderStudentsByGrade(Student[] studentsArr) {

        for (int i = 0; i < studentsArr.length - 1; i++) {
            double bestGrade = studentsArr[i].getGrade();
            int bestGradeIndex = -1;

            for (int j = i + 1; j < studentsArr.length; j++) {

                if (bestGrade < studentsArr[j].getGrade()) {
                    bestGrade = studentsArr[j].getGrade();
                    bestGradeIndex = j;
                }
            }
            if (bestGradeIndex != -1) {
                Student temp = studentsArr[i];
                studentsArr[i] = studentsArr[bestGradeIndex];
                studentsArr[bestGradeIndex] = temp;
            }
        }
        return studentsArr;
    }
}
