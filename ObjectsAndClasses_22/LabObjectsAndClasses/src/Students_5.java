import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_5 {
    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String homeTown;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }


    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();

        String command = reader.nextLine();

        while (!command.equals("end")) {
            String[] currentStudent = command.split(" ");

            String firstName = currentStudent[0];
            String lastName = currentStudent[1];
            int age = Integer.parseInt(currentStudent[2]);
            String homeTown = currentStudent[3];

            Student newStudent = getStudent(studentsList, firstName, lastName);

            if (newStudent != null) {
                newStudent.setAge(age);
                newStudent.setHomeTown(homeTown);
            } else {
                newStudent = new Student(firstName, lastName, age, homeTown);
                studentsList.add(newStudent);
            }

            command = reader.nextLine();
        }

        String filterCity = reader.nextLine();

        for (int i = 0; i < studentsList.size(); i++) {
            Student currentStudent = studentsList.get(i);

            if (currentStudent.getHomeTown().equals(filterCity)) {
                System.out.printf("%s %s is %d years old%n", currentStudent.getFirstName()
                        , currentStudent.getLastName(), currentStudent.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> studentsList, String firstName, String lastName) {

        for (int i = 0; i < studentsList.size(); i++) {
            String currentFName = studentsList.get(i).getFirstName();
            String currentLName = studentsList.get(i).getLastName();

            if (currentFName.equals(firstName) && currentLName.equals(lastName)) {
                return studentsList.get(i);
            }
        }

        return null;
    }
}
