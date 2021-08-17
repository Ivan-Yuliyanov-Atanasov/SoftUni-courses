import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fieldLength = Integer.parseInt(scan.nextLine());
        int [] field = new int [fieldLength];
        int [] indexesOfBugs = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < indexesOfBugs.length; i++) {
            int indexOfBug = indexesOfBugs[i];
            if (indexOfBug >= 0 && indexOfBug < field.length){
                field[indexOfBug] = 1;
            }

        }
        String input ;

        while (!(input = scan.nextLine()).equals("end")){
            String [] tokens = input.split(" ");
            int index = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int step = Integer.parseInt(tokens[2]);
            if(index < 0 || index >= field.length || field[index] == 0 || step == 0){
                continue;
            }

            if ((direction.equals("right") && step >= 0) || (direction.equals("left") && step < 0)){

               int i = index + Math.abs(step);
               if (i >= fieldLength){
                   field[index] = 0;

               }
               while (i < fieldLength){
                   if (field[i] == 0){
                       field[i] = 1;
                       field[index] = 0;
                       break;
                   } else {
                       i += step;
                       if(i >= field.length){
                           field[index] = 0;
                       }
                   }

               }
            }
            if ((direction.equals("left") && step >= 0) || (direction.equals("right") && step < 0)){
                int i = index - Math.abs(step);
                if (i < 0) {
                    field[index] = 0;

                }
                while (i >= 0){
                    if (field[i] == 0){
                        field[i] = 1;
                        field[index] = 0;
                        break;
                    } else {
                        i -= step;
                        if(i <= -1){
                            field[index] = 0;
                        }
                    }

                }
            }

        }
        for (int i : field) {
            System.out.print(i + " ");

        }
    }
}
