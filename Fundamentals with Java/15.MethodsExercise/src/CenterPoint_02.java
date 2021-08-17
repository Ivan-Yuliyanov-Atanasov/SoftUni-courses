import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X1= Integer.parseInt(scan.nextLine());
        int Y1= Integer.parseInt(scan.nextLine());
        int X2= Integer.parseInt(scan.nextLine());
        int Y2= Integer.parseInt(scan.nextLine());

        double firstLine = getDistance(X1,Y1);
        double secondLine = getDistance(X2, Y2);
        if (firstLine <= secondLine){
            System.out.printf("(%d, %d)",X1, Y1);
        } else {
            System.out.printf("(%d, %d)",X2, Y2);
        }
    }

    private static double getDistance(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        double c = a * a + b * b;
        return c = Math.sqrt(c);
    }

}
