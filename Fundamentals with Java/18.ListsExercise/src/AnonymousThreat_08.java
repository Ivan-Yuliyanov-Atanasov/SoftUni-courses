import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("3:1")){
            String [] tokens = inputLine.split("\\s+");
            String command = tokens [0];
            if (command.equals("merge")){
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                boolean flag = true;
                if (startIndex > input.size() - 1){
                    flag = false;
                }
                if (endIndex > input.size()- 1){
                    endIndex = input.size() - 1;
                }
                if (startIndex < 0){
                    startIndex = 0;
                }
                if (flag){
                    int count = endIndex - startIndex;
                    int mergeLength = Math.min(count, input.size() - 1 - startIndex);
                     int counter = 0;
                     while (counter < mergeLength) {
                         counter++;
                          String replaceString = input.get(startIndex).concat(input.get(startIndex + 1));
                          input.set(startIndex, replaceString);
                          input.remove(startIndex + 1);
                    }
                }

            } else {
                int index = Integer.parseInt(tokens[1]);
                int partitions = Integer.parseInt(tokens[2]);
                String word = input.get(index);
                input.remove(index);
                int length = word.length();
                List<String> newList = new ArrayList<>();
                if (length % partitions == 0){
                    int counter = 0;
                    int count = length / partitions;
                    int i = 0;
                    while (counter < partitions){
                        String wordToAdd = word.substring(i, count + i);
                        newList.add(wordToAdd);
                        counter ++;
                        i += count;

                    }
                } else {
                    int counter1 = 0;
                    int count1 = length / partitions;
                    int j = 0;
                    while (counter1 < partitions){
                        String wordToAdd1 = word.substring(j, count1 + j);
                        counter1 ++;
                        j += count1;
                        if (counter1 == partitions){
                            wordToAdd1 = word.substring((counter1 - 1) * count1);

                        }
                        newList.add(wordToAdd1);
                    }
                }
                input.addAll(index,newList);

            }



            inputLine = scan.nextLine();
        }
        for (String s : input) {
            System.out.print(s + " ");

        }

    }
}
