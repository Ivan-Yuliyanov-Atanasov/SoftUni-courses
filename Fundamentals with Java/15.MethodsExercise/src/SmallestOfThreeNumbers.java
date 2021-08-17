import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());

        printSmallestNumber(num1,num2,num3);
    }

    private static void printSmallestNumber(int num1, int num2, int num3) {
        if (num1 < num2 && num1 < num3){
            System.out.println(num1);
        } else if (num2 < num3 && num2 < num1){
            System.out.println(num2);
        } else {
            System.out.println(num3);

        }
    }
}
