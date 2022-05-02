import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] token = scan.nextLine().split(", ");
        int m = Integer.parseInt(token[0]);
        int n = Integer.parseInt(token[1]);
        int result = 0;
        for (int i = 1; i <= m ; i++) {
            String [] input = scan.nextLine().split(", ");
            for (int j = 0; j < input.length; j++) {
                int num = Integer.parseInt(input[j]);
                result += num;

            }
        }
        System.out.println(m);
        System.out.println(n);
        System.out.println(result);
    }
}
