import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int persons = Integer.parseInt(scan.nextLine());
        int capacity = Integer.parseInt(scan.nextLine());
        int counter = 0;
        while (persons > 0){
            counter ++;
            persons -= capacity;
        }
        System.out.println(counter);
    }
}
