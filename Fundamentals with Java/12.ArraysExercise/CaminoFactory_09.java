import java.util.Arrays;
import java.util.Scanner;

public class CaminoFactory_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int[] arrayToPrint = new int[n];
        int max_counter = 0;
        int max_sum = 0;
        int minIndex = Integer.MAX_VALUE;
        int DNANumber = 0;
        int bestDNA = 0;
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Clone them!")){
            boolean flag = false;
            int [] numbers = Arrays.stream(inputLine.split("!+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int Index = 0;
            DNANumber ++;
            int counter = 0;
            int sum = 0;
            for (int k = 0; k < numbers.length; k++) {
                sum += numbers[k];

            }
            if (sum == 1){
                counter++;
                for (int m = 0; m < numbers.length; m++) {
                    if(numbers[m] == 1){
                        Index = m;
                    }
                }
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = i + 1; j < numbers.length; j++) {
                        if (numbers[j] == 1 && numbers[j] == numbers[i]) {
                            if (counter == 0) {
                                Index = j - 1;
                            }
                            counter++;
                        } else {
                            break;
                        }
                    }

                }
                if (sum > 1 && counter == 0){
                    for (int l = 0; l < numbers.length; l++) {
                        if (numbers[l]==1){
                            counter++;
                            Index = l;
                            break;
                        }

                    }
                }
            }
            if (counter > max_counter){
                flag = true;
            } if (counter == max_counter){
                if(Index < minIndex){
                    flag = true;
                }
            } if (counter == max_counter && Index == minIndex){
                if (sum > max_sum){
                    flag = true;
                }
            }
            if(flag){
                max_counter = counter;
                minIndex = Index;
                max_sum = sum;
                for (int j = 0; j < numbers.length; j++) {
                    arrayToPrint[j] = numbers[j];
                    bestDNA = DNANumber;

                }

            }

            inputLine = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",bestDNA,max_sum);
        for (int i : arrayToPrint) {
            System.out.print(i + " ");

        }
    }
}
