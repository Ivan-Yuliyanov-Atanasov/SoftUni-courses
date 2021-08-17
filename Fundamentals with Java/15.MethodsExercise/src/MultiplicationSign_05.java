import java.util.Scanner;

public class MultiplicationSign_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        if(num1==0 || num2 == 0 || num3 == 0){
            System.out.println("zero");
        } else {
            int counter = 0;
            if (num1 < 0){
                counter ++;
            }
            if (num2 < 0){
                counter ++;
            }
            if (num3 < 0){
                counter++;
            }
            if (counter % 2 == 1){
                System.out.println("negative");
            } else {
                System.out.println("positive");
            }

        }
    }
}
