package Froggy_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (! (input = reader.readLine()).equals("END")) {
            int[] numbers = Arrays.stream(input.split("[,\\s+]"))
                    .filter(s -> ! s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Lake lake = new Lake(numbers);

            List<Integer> integers = new ArrayList<>();
            lake.forEach(integers::add);
            System.out.println(integers.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
