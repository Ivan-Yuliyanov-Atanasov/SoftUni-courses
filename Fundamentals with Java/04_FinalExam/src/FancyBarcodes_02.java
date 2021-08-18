import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "@#+([A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n ; i++) {
            String inputLine = scan.nextLine();
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                String code = "";
                for (int j = 1; j < inputLine.length() - 2; j++) {
                    if(Character.isDigit(inputLine.charAt(j))){
                        code += inputLine.charAt(j);
                    }

                }
                if(!code.isEmpty()){
                    System.out.printf("Product group: %s%n",code);
                } else {
                    System.out.println("Product group: 00");;
                }

            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
