import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers1 =  Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int [] numbers2 =  Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n = numbers1.length;
        int sum = 0;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (numbers1[i] != numbers2[i]){
                flag = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.",i);
                break;
            } else {
                sum += numbers1[i];
            }

        }
        if (flag){
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
