import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] words = scan.nextLine().split(" ");
        Random generator = new Random();

        for (int i = 0; i < words.length; i++) {
            int x = generator.nextInt(words.length);
            int y = generator.nextInt(words.length);
            String oldWord = words[x];
            words[x] = words[y];
            words[y] = oldWord;


        }
        for (String word : words) {
            System.out.println(word);

        }
    }
}
