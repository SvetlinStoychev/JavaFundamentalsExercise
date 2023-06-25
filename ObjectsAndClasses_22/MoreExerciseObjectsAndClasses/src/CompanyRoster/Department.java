package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employeeList = new ArrayList<>();

    public void add(Employee employee) {
        employeeList.add(employee);
    }

    public double calculateBestAverageDepartment() {
        int departmentCnt = 0;
        double salarySum = 0;
        double bestAverage = 0;

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
            }
        }

        return bestAverage;
    }
}
