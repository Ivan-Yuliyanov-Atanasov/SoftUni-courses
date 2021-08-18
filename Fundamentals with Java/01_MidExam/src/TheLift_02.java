import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int [] lift = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int peopleInLift = 0;

        for (int i = 0; i < lift.length; i++) {
            peopleInLift += lift[i];
        }
        int freeSpace = lift.length * 4 - peopleInLift;
        if (people == freeSpace){
            for (int i = 0; i < lift.length; i++) {
                lift[i] = 4;

            }
        } else if (people < freeSpace){
            for (int i = 0; i < lift.length; i++) {
                int singleLiftSpace = 4 - lift[i];
                if (people >= singleLiftSpace){
                    lift[i] = 4;
                    people -= singleLiftSpace;
                } else {
                    lift[i] += people;
                    break;
                }

            }
            System.out.println("The lift has empty spots!");
        } else {
            int peopleQueue = people - freeSpace;
            for (int i = 0; i < lift.length; i++) {
                lift[i] = 4;

            }
            System.out.printf("There isn't enough space! %d people in a queue!%n",peopleQueue);

        }
        for (int i : lift) {
            System.out.print(i + " ");

        }
    }
}
