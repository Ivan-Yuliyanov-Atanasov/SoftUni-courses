import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = 255;
        int sum = 0;
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n ; i++) {
            int water = Integer.parseInt(scan.nextLine());
            if (water > capacity){
                System.out.println("Insufficient capacity!");
            } else {
                sum += water;
                capacity -= water;
            }

        }
        System.out.println(sum);
    }
}
