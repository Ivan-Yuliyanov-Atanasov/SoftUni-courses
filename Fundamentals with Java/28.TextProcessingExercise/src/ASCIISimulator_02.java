import java.util.Scanner;

public class ASCIISimulator_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstSymbol = scan.nextLine().charAt(0);
        char secondSymbol = scan.nextLine().charAt(0);
        String inputLine = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < inputLine.length(); i++) {
            char currentSymbol = inputLine.charAt(i);
            if((currentSymbol > firstSymbol && currentSymbol < secondSymbol) || (currentSymbol > secondSymbol && currentSymbol < firstSymbol)){
                sum += (int) currentSymbol;
            }

        }
        System.out.println(sum);
    }
}
