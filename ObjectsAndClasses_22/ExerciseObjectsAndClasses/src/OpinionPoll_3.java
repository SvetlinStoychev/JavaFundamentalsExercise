import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll_3 {
    public static class Person {
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static void sortPersonsByAge(List<Person> personList, int age) {
            for(Person person : personList) {
                if (person.age > age) {
                    System.out.printf("%s - %d%n", person.name, person.age);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personalInfo = reader.nextLine().split(" ");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);

            Person currentPerson = new Person(name, age);
            personList.add(currentPerson);
        }

        Person.sortPersonsByAge(personList, 30);
    }
}
