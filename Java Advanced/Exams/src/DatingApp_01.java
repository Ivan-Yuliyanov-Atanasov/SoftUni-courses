import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class DatingApp_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> male = new ArrayDeque<>();
        ArrayDeque<Integer> female = new ArrayDeque<>();
        int [] maleNumbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] femaleNumbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < maleNumbers.length; i++) {
            if(maleNumbers[i] > 0){
                male.push(maleNumbers[i]);
            }


        }
        for (int i = 0; i < femaleNumbers.length; i++) {
            if(femaleNumbers[i] > 0){
                female.offer(femaleNumbers[i]);
            }


        }
        int counter = 0;
        while(!male.isEmpty() && !female.isEmpty()){
            int currentMale = male.peek();
            int currentFemale = female.peek();
            if(currentMale % 25 == 0 && currentFemale % 25 == 0 && currentFemale == currentMale){
                counter++;
                male.pop();
                male.pop();
                female.poll();
                female.poll();
            }
            else if(currentMale % 25 == 0){
                if(male.size() > 1){
                    male.pop();
                    male.pop();
                } else {
                    male.pop();
                }

            }
            else if(currentFemale % 25 == 0){
                if(female.size() > 1){
                    female.poll();
                    female.poll();
                } else {
                    female.poll();
                }

            }
            else if(currentFemale == currentMale ) {
                counter++;
                male.pop();
                female.poll();
            } else {
                female.poll();
                currentMale -= 2;
                male.pop();
                if(currentMale > 0){
                    male.push(currentMale);
                }
            }
        }
        System.out.println("Matches: " + counter);
        if (!male.isEmpty()){
            System.out.println("Males left: " + male.toString().replace("[","").replace("]",""));
            System.out.println("Females left: none");
        } else if (!female.isEmpty()){
            System.out.println("Males left: none");
            System.out.println("Females left: " + female.toString().replace("[","").replace("]",""));

        } else {
            System.out.println("Males left: none");
            System.out.println("Females left: none");
        }
    }
}
