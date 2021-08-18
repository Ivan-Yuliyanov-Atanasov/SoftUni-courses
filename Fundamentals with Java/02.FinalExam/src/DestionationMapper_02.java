import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestionationMapper_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "(\\/|=)(?<destination>[A-Z][A-za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scan.nextLine());
        List<String> destinations = new ArrayList<>();
        while (matcher.find()){
            destinations.add(matcher.group("destination"));
        }
        int travelPoints = 0;
        for (int i = 0; i < destinations.size(); i++) {
            travelPoints += destinations.get(i).length();

        }
        String output = destinations.toString().replaceAll("[\\[\\]]","");
        System.out.printf("Destinations: %s%n",output);
        System.out.printf("Travel Points: %d",travelPoints);
    }
}
