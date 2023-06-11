import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    private static List<String> scheduleLessons = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        scheduleLessons = Arrays.stream(reader.nextLine().split(", ")).collect(Collectors.toList());

        String command = reader.nextLine();

        while (!command.equals("course start")) {
            String[] commandsArr = command.split(":");
            String currentCommand = commandsArr[0];
            String lessonTitle = commandsArr[1];
            String exerciseTitle = lessonTitle + "-Exercise";

            switch (currentCommand) {
                case "Add":
                    if (!isLessonExist(lessonTitle)) {
                        scheduleLessons.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    if (!isLessonExist(lessonTitle)) {
                        int index = Integer.parseInt(commandsArr[2]);
                        scheduleLessons.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    if (isLessonExist(lessonTitle)) {
                        scheduleLessons.remove(lessonTitle);
                        if (isExerciseExist(exerciseTitle)) {
                            scheduleLessons.remove(exerciseTitle);
                        }
                    }
                    break;
                case "Swap":
                    String secondLessonTitle = commandsArr[2];
                    String secondExerciseTitle = secondLessonTitle + "-Exercise";
                    if (isLessonExist(lessonTitle) && isLessonExist(secondLessonTitle)) {
                        int lessonIndex = scheduleLessons.indexOf(lessonTitle);
                        int secondLessonIndex = scheduleLessons.indexOf(secondLessonTitle);
                        scheduleLessons.set(lessonIndex, secondLessonTitle);
                        scheduleLessons.set(secondLessonIndex, lessonTitle);

                        if (isExerciseExist(exerciseTitle)) {
                            int exerciseIndex = scheduleLessons.indexOf(lessonTitle);
                            scheduleLessons.remove(exerciseTitle);
                            scheduleLessons.add(exerciseIndex + 1, exerciseTitle);
                        }

                        if (isExerciseExist(secondExerciseTitle)) {
                            int exerciseIndex = scheduleLessons.indexOf(secondLessonTitle);
                            scheduleLessons.remove(secondExerciseTitle);
                            scheduleLessons.add(exerciseIndex + 1, secondExerciseTitle);
                        }
                    }
                    break;
                case "Exercise":
                    if (isLessonExist(lessonTitle)) {
                        int lessonIndex = scheduleLessons.indexOf(lessonTitle);
                        if (lessonIndex < scheduleLessons.size() - 1) {
                            if (!scheduleLessons.get(lessonIndex + 1).equals(exerciseTitle)) {
                                scheduleLessons.add(lessonIndex + 1, exerciseTitle);
                            }
                        } else {
                            scheduleLessons.add(exerciseTitle);
                        }
                    } else {
                        scheduleLessons.add(lessonTitle);
                        scheduleLessons.add(exerciseTitle);
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        printScheduleLessons();
    }

    private static boolean isExerciseExist(String exerciseTitle) {
        if (scheduleLessons.contains(exerciseTitle)) {
            return true;
        } else {
            return false;
        }
    }

    private static void printScheduleLessons() {
        for (int i = 1; i <= scheduleLessons.size(); i++) {
            System.out.printf("%d.%s%n", i, scheduleLessons.get(i - 1));
        }
    }

    private static boolean isLessonExist(String lessonTitle) {
       if (scheduleLessons.contains(lessonTitle)) {
           return true;
       } else {
           return false;
       }
    }
}
