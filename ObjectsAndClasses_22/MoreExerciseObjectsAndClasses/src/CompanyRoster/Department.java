package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employeeList = new ArrayList<>();
    private double bestAverage;
    private String bestDepartment;

    public void add(Employee employee) {
        employeeList.add(employee);
    }

    private void calculateBestAverageDepartment() {
        int departmentCnt = 0;
        double salarySum = 0;

        for (int i = 0; i < employeeList.size() - 1; i++) {
            departmentCnt++;
            salarySum += employeeList.get(i).getSalary();

            for (int j = i + 1; j < employeeList.size(); j++) {

                if (employeeList.get(i).getDepartment().equals(employeeList.get(j).getDepartment())) {
                    departmentCnt++;
                    salarySum += employeeList.get(j).getSalary();
                }
            }

            double currentAverage = salarySum / departmentCnt;

            if (currentAverage > bestAverage) {
                bestAverage = currentAverage;
                bestDepartment = employeeList.get(i).getDepartment();
            }
        }
    }
    public void printBestAverageDepartmentData() {
        calculateBestAverageDepartment();

        System.out.println("Highest Average Salary: " + this.bestDepartment);

        for (int i = 0; i < employeeList.size() - 1; i++) {
            double bestSalary = 0;
            int bestSalaryIndex = -1;

            if (employeeList.get(i).getDepartment().equals(this.bestDepartment)) {
                bestSalary = employeeList.get(i).getSalary();
            }

            for (int j = i + 1; j < employeeList.size(); j++) {

                if (employeeList.get(j).getDepartment().equals(this.bestDepartment)
                    && employeeList.get(j).getSalary() > bestSalary) {

                    bestSalary = employeeList.get(j).getSalary();
                    bestSalaryIndex = j;
                }
            }

            if (bestSalaryIndex != -1) {
                Employee temp = employeeList.get(i);
                employeeList.set(i, employeeList.get(bestSalaryIndex));
                employeeList.set(bestSalaryIndex, temp);
            }
        }

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getDepartment().equals(this.bestDepartment)) {

                System.out.printf("%s %.2f %s %d%n", employeeList.get(i).getName(), employeeList.get(i).getSalary()
                    , employeeList.get(i).getEmail(), employeeList.get(i).getAge());

            }
        }
    }
}
