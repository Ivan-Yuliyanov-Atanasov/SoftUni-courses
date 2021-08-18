import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> courses = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String input = scan.nextLine();
        while(!input.equals("course start")){
            String [] tokens = input.split(":");
            String command = tokens[0];
            String lesson = tokens[1];
            switch (command){

                case "Add":
                    if(!courses.contains(lesson)){
                        courses.add(lesson);
                    }
                    break;
                case "Remove":
                    String exercise = lesson + "-Exercise";
                    if(courses.contains(lesson)){
                        courses.remove(lesson);
                    }
                    if(courses.contains(exercise)){
                        courses.remove(exercise);
                    }

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!courses.contains(lesson)){
                        courses.add(index,lesson);
                    }
                    break;
                case "Exercise":
                    String exerciseToAdd = lesson + "-Exercise";
                    if(courses.contains(lesson) && !courses.contains(exerciseToAdd)){
                        int lessonIndex = courses.indexOf(lesson);
                        courses.add(lessonIndex + 1,exerciseToAdd);
                    } else if (!courses.contains(lesson)){
                        courses.add(lesson);
                        courses.add(exerciseToAdd);
                    }
                    break;
                case "Swap":
                    String exerciseLesson = lesson + "-Exercise";
                    String lesson2 = tokens[2];
                    String exerciseLesson2 = lesson2 + "-Exercise";
                    if(courses.contains(lesson) && courses.contains(lesson2)) {
                        int swap = 0;
                        int indexLesson = courses.indexOf(lesson);
                        int indexLesson2 = courses.indexOf(lesson2);
                        swap = indexLesson;
                        indexLesson = indexLesson2;
                        indexLesson2 = swap;
                        courses.set(indexLesson, lesson);
                        courses.set(indexLesson2, lesson2);
                        if (courses.contains(exerciseLesson)) {
                            int indexRemove = courses.indexOf(exerciseLesson);
                            courses.remove(indexRemove);
                            courses.add(indexLesson + 1,exerciseLesson);


                        }
                        if (courses.contains(exerciseLesson2)) {
                            int indexRemove2 = courses.indexOf(exerciseLesson2);
                            courses.remove(indexRemove2);
                            courses.add(indexLesson2 + 1, exerciseLesson2);

                        }
                    }
                    break;


            }
            input = scan.nextLine();
        }
        for (int i = 0; i <courses.size(); i++) {
            System.out.printf("%d.%s%n",i+1,courses.get(i));

        }
    }
}
