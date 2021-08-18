
import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder toPrint = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            toPrint.append(input.charAt(i));
        }



        int i = 0;
        int sumLeftPower = 0;
        while (i < toPrint.length() - 1){
            if (toPrint.charAt(i) == '>' && toPrint.charAt(i+1) != '0'){
                char symbol = toPrint.charAt(i + 1);
                String stringPower = "";
                stringPower += symbol;
                int power = Integer.parseInt(stringPower) + sumLeftPower;
                int currentIndex = i;
                int counter = 0;
                int n = Math.min(power,toPrint.length() - 1 - currentIndex);
                for (int j = 0; j < n ; j++) {

                    if (toPrint.charAt(currentIndex + 1) == '>'){
                        sumLeftPower += (power - counter);

                        break;
                    }
                    toPrint.deleteCharAt(currentIndex + 1);

                    counter ++;
                }
               i++;

            } else {
                i++;
            }
        }
        for (int j = 0; j < toPrint.length(); j++) {
            if (toPrint.charAt(j) == '0'){
                toPrint.deleteCharAt(j);
            }

        }
        System.out.println(toPrint.toString());


    }
}
