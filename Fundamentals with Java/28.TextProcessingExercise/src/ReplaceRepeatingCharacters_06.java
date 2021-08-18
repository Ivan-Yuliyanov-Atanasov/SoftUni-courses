import java.util.Scanner;

public class ReplaceRepeatingCharacters_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder toPrint = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            toPrint.append(input.charAt(i));

        }
        int j = 0;
        while(j<toPrint.length() - 1){
            if (toPrint.charAt(j) == toPrint.charAt(j + 1)){
                toPrint.deleteCharAt(j);
            } else {
                j++;
            }
        }
        System.out.println(toPrint.toString());

    }

}
