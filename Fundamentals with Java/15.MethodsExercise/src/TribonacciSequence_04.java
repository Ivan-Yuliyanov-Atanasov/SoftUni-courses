import java.util.Scanner;

public class TribonacciSequence_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int [] numbers = new int[num];

        if(num == 1){
            System.out.println(1);
        } else if (num == 2) {
            System.out.print(1 + " ");
            System.out.print(1);
        } else if (num == 3){
            System.out.print(1 + " ");
            System.out.print(1 + " ");
            System.out.print(2);
        } else {
            numbers[0] = 1;
            numbers[1] = 1;
            numbers[2] = 2;
            for (int i = 3; i < num; i++) {
            numbers[i] = numbers [i - 3] + numbers [i - 2] + numbers [i - 1];

        }
            for (int number : numbers) {
                System.out.print(number + " ");

            }
        }

    }
}
