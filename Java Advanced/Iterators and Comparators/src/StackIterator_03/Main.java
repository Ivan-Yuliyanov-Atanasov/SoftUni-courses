package StackIterator_03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack <Integer> stack = new Stack<>();
//        Arrays.stream((reader.readLine()).split("[, ]+"))
//        .skip(1)
//                .mapToInt(Integer::parseInt)
//                .forEach(stack::push);

        String input;

        while(!(input = reader.readLine()).equals("END")){
            String [] tokens = input.split("[, ]+");
            String command = tokens [0];
            if(command.equals("Pop")){
                try {
                    stack.pop();
                } catch (Exception e){
                    System.out.println("No elements");

                }

            } else {

                for (int i = 1; i <tokens.length ; i++) {
                    stack.push(Integer.parseInt(tokens[i]));
                }
//                int n = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
//                stack.push(n);
            }

        }
        for (Object o : stack) {
            System.out.println(o);

        }
        for (Object o : stack) {
            System.out.println(o);

        }
    }

}
