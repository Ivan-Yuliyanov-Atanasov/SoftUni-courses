import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(\\|||#)(?<name>[A-Za-z ]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);
        String inpulLine = scan.nextLine();
        Matcher matcher = pattern.matcher(inpulLine);
        int totalCalories = 0;
        ArrayList<String> foods = new ArrayList<>();
        while (matcher.find()){
            String food = matcher.group("name");
            String date = matcher.group("date");
            String calories = (matcher.group("calories"));
            foods.add(food);
            foods.add(date);
            foods.add(calories);

            totalCalories += Integer.parseInt(calories);
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n",days);
        int i = 0;
        int j = 0;
        while (j < foods.size() / 3){

            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",foods.get(i),foods.get(i+1),foods.get(i+2));
            j++;
            i += 3;
        }


    }
}
