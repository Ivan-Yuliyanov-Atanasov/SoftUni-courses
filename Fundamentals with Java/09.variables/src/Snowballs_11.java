import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        long maxSnowballValue = Integer.MIN_VALUE;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality =0;
        for (int i = 1; i <= n ; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());
            double divide = 1;
            if (snowballTime != 0) {
                divide = (double) snowballSnow / (double) snowballTime;
            }

            double snowballValue = Math.pow((divide),(double) snowballQuality);

            long snowballValue1 = (long) snowballValue;
            if (snowballValue > maxSnowballValue){
                maxSnowballValue = snowballValue1;
                bestSnowballSnow = snowballSnow;
                bestSnowballQuality = snowballQuality;
                bestSnowballTime = snowballTime;
            }

        }
        System.out.printf("%d : %d = %d (%d)",bestSnowballSnow,bestSnowballTime,maxSnowballValue,bestSnowballQuality);

    }
}
