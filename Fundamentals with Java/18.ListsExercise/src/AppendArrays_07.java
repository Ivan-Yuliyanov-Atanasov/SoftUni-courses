import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        //input = input.replaceAll("\\s+","");
        List<String> tokens = Arrays.stream(input.split("\\|")).collect(Collectors.toList());
        Collections.reverse(tokens);
        String toPrint = tokens.toString().replaceAll("[\\]\\[,]","").trim();
        toPrint = toPrint.replaceAll("\\s+"," ");
        System.out.println(toPrint);

    }
}
