import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        int [] train = new int[n];
        for (int i = 0; i < train.length; i++) {
            train[i] = Integer.parseInt(scan.nextLine());

        }
        for (int i : train) {
            sum += i;
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.printf("%d",sum);
    }
}
