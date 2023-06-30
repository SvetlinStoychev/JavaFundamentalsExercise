import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CompanyUsers_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, ArrayList<String>> companyInfoMap = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" -> ");

            String inputCompanyName = commandArr[0];
            String inputEmployeeId = commandArr[1];

            if (!companyInfoMap.containsKey(inputCompanyName)) {

                ArrayList<String> employeeList = new ArrayList<>();
                employeeList.add(inputEmployeeId);
                companyInfoMap.put(inputCompanyName, employeeList);

            } else {
                ArrayList<String> currentEmployeeList = companyInfoMap.get(inputCompanyName);

                if (!currentEmployeeList.contains(inputEmployeeId)) {
                    currentEmployeeList.add(inputEmployeeId);
                    companyInfoMap.put(inputCompanyName, currentEmployeeList);
                }
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : companyInfoMap.entrySet()) {
            ArrayList<String> value = entry.getValue();

            System.out.println(entry.getKey());

            for (String id : value) {
                System.out.printf("-- %s%n", id);
            }
        }
    }
}
