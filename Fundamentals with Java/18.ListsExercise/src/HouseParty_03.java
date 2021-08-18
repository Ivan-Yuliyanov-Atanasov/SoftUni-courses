import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {

            String [] input = scan.nextLine().split(" ");
            String name = input[0];
            int length = input.length;
            if (length == 3){
                if (names.contains(name)){
                    System.out.printf("%s is already in the list!%n",name);
                } else {
                    names.add(name);
                }
            } else if (length == 4){
                if(names.contains(name)){
                    names.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n",name);
                }
            }

        }
        for (String name : names) {
            System.out.println(name);

        }
    }
}
