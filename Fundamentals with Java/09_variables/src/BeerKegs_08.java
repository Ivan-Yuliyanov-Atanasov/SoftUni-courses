import java.util.Scanner;

public class BeerKegs_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double maxVolume = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 1; i <= n ; i++) {
            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            double volume = Math.PI * radius * radius * height;
            if (volume > maxVolume){
                maxVolume = volume;
                winner = model;
            }

        }
        System.out.println(winner);
    }
}
