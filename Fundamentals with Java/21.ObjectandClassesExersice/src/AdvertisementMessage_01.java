import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String [] phrases = {"Excellent product.","Such a great product.","I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String [] events ={"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String [] names = {"DIana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String [] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random generator = new Random();
        for (int i = 0; i < n; i++) {
            int num1 = generator.nextInt(phrases.length);
            String phrase = phrases[num1];
            int num2 = generator.nextInt(events.length);
            String event = events[num2];
            int num3 = generator.nextInt(names.length);
            String name = names[num3];
            int num4 = generator.nextInt(cities.length);
            String city = phrases[num4];
            System.out.println(phrase + " " + event + " " + name + " - " + city);

        }
    }
}
