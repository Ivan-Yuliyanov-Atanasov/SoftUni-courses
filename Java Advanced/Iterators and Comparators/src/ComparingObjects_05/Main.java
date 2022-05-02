package ComparingObjects_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        String input = "";
        while(!(input = reader.readLine()).equals("END")){
            String [] tokens = input.split(" ");
            Person person = new Person(tokens);
            list.add(person);
        }
        int n = Integer.parseInt(reader.readLine());
        int countEqual = 1;
        Person person = list.get(n - 1);
        for (int i = 0; i < list.size(); i++) {
            if(i == n - 1){
                continue;
            } else {
                if(person.compareTo(list.get(i)) == 0){
                    countEqual ++;
                }
            }


        }
        if(countEqual == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d",countEqual,list.size() - countEqual, list.size());
        }
    }
}
