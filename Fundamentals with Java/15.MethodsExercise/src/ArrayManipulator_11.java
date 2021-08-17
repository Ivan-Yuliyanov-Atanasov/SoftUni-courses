import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] inputArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String command = scan.nextLine();
        while (!command.equals("end")){
            String [] tokens = command.split(" ");
            String action = tokens[0];
            switch (action){

                case "exchange":
                    int exchangeIndex = Integer.parseInt(tokens[1]);
                    int [] exchangeArray = new int[inputArray.length];
                    if (exchangeIndex < 0 || exchangeIndex > inputArray.length - 1){
                        System.out.println("Invalid index");
                    } else {
                        for (int i = 0; i < exchangeArray.length - 1 - exchangeIndex; i++) {
                            exchangeArray[i] = inputArray[exchangeIndex + 1 + i];
                        }
                        for (int i = exchangeArray.length - 1 - exchangeIndex; i < inputArray.length ; i++) {
                            exchangeArray[i] = inputArray[i - (exchangeArray.length - 1 - exchangeIndex)];

                        }
                        inputArray = exchangeArray;
                    }

                    break;
                case "max":
                    int maxNumber = Integer.MIN_VALUE;
                    int currentIndex = 0;
                    if (tokens[1].equals("even")){
                        for (int i = 0; i < inputArray.length; i++) {
                            if(inputArray[i] >= maxNumber && inputArray[i] % 2 == 0){
                                maxNumber = inputArray[i];
                                currentIndex = i;
                            }
                        }
                    } else {
                        for (int i = 0; i < inputArray.length; i++) {
                            if(inputArray[i] >= maxNumber && inputArray[i] % 2 == 1){
                                maxNumber = inputArray[i];
                                currentIndex = i;
                            }
                        }
                    }
                    if (maxNumber == Integer.MIN_VALUE){
                        System.out.println("No matches");
                    } else {
                        System.out.println(currentIndex);
                    }
                    break;

                case "min":
                    int minNumber = Integer.MAX_VALUE;
                    int minCurrentIndex = 0;
                    if (tokens[1].equals("even")){
                        for (int i = 0; i < inputArray.length; i++) {
                            if(inputArray[i] <= minNumber && inputArray[i] % 2 == 0){
                                minNumber = inputArray[i];
                                minCurrentIndex = i;
                            }
                        }
                    } else {
                        for (int i = 0; i < inputArray.length; i++) {
                            if(inputArray[i] <= minNumber && inputArray[i] % 2 == 1){
                                minNumber = inputArray[i];
                                minCurrentIndex = i;
                            }
                        }
                    }
                    if (minNumber == Integer.MAX_VALUE){
                        System.out.println("No matches");
                    } else {
                        System.out.println(minCurrentIndex);
                    }
                    break;

                case "first":
                    int firstCount = Integer.parseInt(tokens[1]);
                    List<Integer> firstCountListEven = new ArrayList<>();
                    List<Integer> firstCountListOdd = new ArrayList<>();
                    boolean invalidCount = false;
                    if(firstCount > inputArray.length){
                        invalidCount = true;
                        System.out.println("Invalid count");
                    }
                    if(tokens[2].equals("even")){
                        for (int i = 0; i < inputArray.length; i++) {
                            if(inputArray[i] % 2 == 0){
                                firstCountListEven.add(inputArray[i]);
                            }
                            if(firstCountListEven.size() == firstCount){
                                break;
                            }
                        }
                        if(!invalidCount) {
                            System.out.println(firstCountListEven);
                        }
                    } else {
                        for (int i = 0; i < inputArray.length; i++) {
                            if(inputArray[i] % 2 == 1){
                                firstCountListOdd.add(inputArray[i]);
                            }
                            if(firstCountListOdd.size() == firstCount){
                                break;
                            }
                        }
                        if(!invalidCount) {
                            System.out.println(firstCountListOdd);
                        }
                    }
                    break;
                case "last":
                    int lastCount = Integer.parseInt(tokens[1]);
                    List<Integer> LastCountListEven = new ArrayList<>();
                    List<Integer> LastCountListOdd = new ArrayList<>();
                    boolean invalidLastCount = false;
                    if(lastCount > inputArray.length){
                        invalidLastCount = true;
                        System.out.println("Invalid count");
                    }
                    if(tokens[2].equals("even")){
                        for (int i = inputArray.length - 1; i >= 0 ; i--) {
                            if(inputArray[i] % 2 == 0){
                                LastCountListEven.add(0,inputArray[i]);
                            }
                            if(LastCountListEven.size() == lastCount){
                                break;
                            }
                        }
                        if(!invalidLastCount) {
                            System.out.println(LastCountListEven);
                        }
                    } else {
                        for (int i = inputArray.length - 1; i >= 0; i--) {
                            if(inputArray[i] % 2 == 1){
                                LastCountListOdd.add(0,inputArray[i]);
                            }
                            if(LastCountListOdd.size() == lastCount){
                                break;
                            }
                        }
                        if(!invalidLastCount) {
                            System.out.println(LastCountListOdd);
                        }
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(Arrays.toString(inputArray));
    }
}
