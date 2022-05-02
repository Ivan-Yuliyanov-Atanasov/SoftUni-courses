package GenericBox_01;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Box <Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String inputLine = reader.readLine();
            box.addData(Double.parseDouble(inputLine));

        }
        double element = Double.parseDouble(reader.readLine());

        System.out.println(box.countGreaterThan(element));
//        int firstIndex = Integer.parseInt(indexes.split(" ")[0]);
//        int secondIndex = Integer.parseInt(indexes.split(" ")[1]);
//        box.swapElements(firstIndex,secondIndex);
//        System.out.println(box.toString());
    }
}
