package ListyIterator_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String [] tokens = reader.readLine().split(" ");
        if(tokens.length > 1){
            for (int i = 1; i < tokens.length; i++) {
                list.add(tokens[i]);

            }
        }
        ListyIterator listyIterator = new ListyIterator(list);
        String input = "";
        while(!(input = reader.readLine()).equals("END")){
            switch (input){
                case "Move":
                    listyIterator.move();
                    break;
                case "HasNext":
                    if(listyIterator.hasNext()){
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "Print":
                    try {
                        listyIterator.Print();
                    } catch (Exception e){
                        System.out.println("Invalid Operation!");
                    }

                    break;
                case "PrintAll":
                    listyIterator.PrintAll();
                    break;
            }
        }
    }
}
