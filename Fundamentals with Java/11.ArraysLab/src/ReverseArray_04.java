import java.util.Scanner;

public class ReverseArray_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] array = scan.nextLine().split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array [i] + " ");

        }
    }
}
