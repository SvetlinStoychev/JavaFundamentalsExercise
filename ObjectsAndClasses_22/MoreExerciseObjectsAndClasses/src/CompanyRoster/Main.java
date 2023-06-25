package CompanyRoster;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Department departmentObj = new Department();

        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < n; i++) {
            String[] dataArr = reader.nextLine().split(" ");
            String name = dataArr[0];
            double salary = Double.parseDouble(dataArr[1]);
            String  position = dataArr[2];
            String department = dataArr[3];

            if (dataArr.length == 6) {
                String email = dataArr[4];
                int age = Integer.parseInt(dataArr[5]);
                Employee currentEmployee = new Employee(name, salary, position, department, email, age);
                departmentObj.add(currentEmployee);
            } else if (dataArr.length == 5){
                boolean isNumeric = dataArr[4].chars().allMatch(Character::isDigit);
                if (isNumeric) {
                    int age = Integer.parseInt(dataArr[4]);
                    Employee currentEmployee = new Employee(name, salary, position, department, age);
                    departmentObj.add(currentEmployee);
                } else {
                    String email = dataArr[4];
                    Employee currentEmployee = new Employee(name, salary, position, department, email);
                    departmentObj.add(currentEmployee);
                }
            } else {
                Employee currentEmployee = new Employee(name, salary, position, department);
                departmentObj.add(currentEmployee);
            }
        }
    }
}
