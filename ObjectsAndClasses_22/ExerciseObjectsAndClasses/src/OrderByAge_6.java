import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge_6 {
    public static class Person {
        private String name;
        private String id;
        private int age;
        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
        public String getName() {
            return this.name;
        }
        public String getId() {
            return this.id;
        }
        public int getAge() {
            return this.age;
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();
        String command = reader.nextLine();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" ");
            String name = commandArr[0];
            String id = commandArr[1];
            int age = Integer.parseInt(commandArr[2]);

            Person currentPerson = new Person(name, id, age);
            personList.add(currentPerson);

            command = reader.nextLine();
        }

        for (int i = 0; i < personList.size() - 1; i++) {
            int minAge = personList.get(i).getAge();
            int minAgeIndex = -1;

            for (int j = i + 1; j < personList.size(); j++) {

                if (minAge > personList.get(j).getAge()) {
                    minAge = personList.get(j).getAge();
                    minAgeIndex = j;
                }
            }

            if (minAgeIndex != -1) {
                Person temp = personList.remove(i);
                personList.add(i, personList.get(minAgeIndex - 1));
                personList.set(minAgeIndex, temp);
            }
        }

        for (Person person : personList) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge());
        }
    }
}
