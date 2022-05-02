package CustomList_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> customList = new CustomList<>();
        String inputLine = "";
        while (!(inputLine = reader.readLine()).equals("END")){
            String [] tokens = inputLine.split(" ");
            String command = tokens [0];
            switch (command){
                case "Add":
                    customList.addElement(tokens[1]);
                    break;
                case "Remove":
                    customList.removeElement(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    if(customList.containsElement(tokens[1])){
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "Swap":
                    customList.swapElements(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
//                    for (int i = 0; i < customList.getSize(); i++) {
//                        System.out.println(customList.getElement(i));
//
//                    }
                    for (String element : customList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
        }
    }
}
