import java.util.Scanner;

public class DataType_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        switch (command){
            case "int":
                int num = Integer.parseInt(scan.nextLine());
                System.out.println(multiplyByTwo(num));
                break;
            case "real":
                double doubleNum = Double.parseDouble(scan.nextLine());
                double numberToPrint = multiplyByOneAndHalf(doubleNum);
                System.out.printf("%.2f",numberToPrint);
                break;
            default:
                String s = scan.nextLine();
                printString(s);

        }
    }

    private static void printString(String command) {
        System.out.println("$" + command + "$");
    }

    static int multiplyByTwo (int number){
        int sum = number * 2;
        return sum;
    }
    static double multiplyByOneAndHalf (double number){
        double sum = number * 1.5;
        return sum;
    }

}

