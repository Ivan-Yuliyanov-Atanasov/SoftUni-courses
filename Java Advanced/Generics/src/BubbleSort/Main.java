package BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(3);
        numbers.add(17);
        numbers.add(6);
        for (int i = 0; i < numbers.size(); i++) {
            int element = numbers.get(i);
            for (int j = 0; j < numbers.size() - 1; j++) {
                int nextElement = numbers.get(j);
                if(element - nextElement < 0){
                    swap(numbers,i,j);
                }

            }


        }
        for (Integer number : numbers) {
            System.out.println(number);

        }
    }

    private static void swap(List<Integer> numbers, int i, int j) {
        int helpElement = numbers.get(i);
        numbers.set(i,numbers.get(j));
        numbers.set(j,helpElement);
    }
}
