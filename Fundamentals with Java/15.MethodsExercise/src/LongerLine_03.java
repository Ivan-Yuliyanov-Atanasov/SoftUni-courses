import java.util.Scanner;

public class LongerLine_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X1= Integer.parseInt(scan.nextLine());
        int Y1= Integer.parseInt(scan.nextLine());
        int X2= Integer.parseInt(scan.nextLine());
        int Y2= Integer.parseInt(scan.nextLine());
        int X3= Integer.parseInt(scan.nextLine());
        int Y3= Integer.parseInt(scan.nextLine());
        int X4= Integer.parseInt(scan.nextLine());
        int Y4= Integer.parseInt(scan.nextLine());
        int a1 = X1 - X2;
        int b1 = Y1 - Y2;
        int a2 = X3 - X4;
        int b2 = Y3 - Y4;
        double sumFirstLine = getDistance(a1,b1);
        double sumSecondLine = getDistance(a2, b2);
        double firstLine = getDistance(X1,Y1);
        double secondLine = getDistance(X2, Y2);
        double thirdLine = getDistance(X3, Y3);
        double fourthLine = getDistance(X4, Y4);
        if (sumFirstLine >= sumSecondLine){
            if (firstLine <= secondLine){
                System.out.printf("(%d, %d)(%d, %d)",X1, Y1, X2, Y2);
            } else {
                System.out.printf("(%d, %d)(%d, %d)",X2, Y2, X1, Y1);
            }
        } else {
            if (thirdLine <= fourthLine){
                System.out.printf("(%d, %d)(%d, %d)",X3, Y3, X4, Y4);
            } else {
                System.out.printf("(%d, %d)(%d, %d)",X4, Y4, X3, Y3);
            }
        }
    }

    private static double getDistance(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        double c = a * a + b * b;
        return c = Math.sqrt(c);
    }

}
