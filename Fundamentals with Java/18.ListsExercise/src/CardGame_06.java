import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> deck1 = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> deck2 = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < deck1.size(); i++) {
            int card1 = deck1.get(i);
            int card2= deck2.get(i);
            sum1 += card1;
            sum2 += card2;

        }
        while (true){
            int pl1card = deck1.get(0);
            int pl2card = deck2.get(0);
            if (pl1card > pl2card){
                deck1.add(pl1card);
                deck1.add(pl2card);
                deck1.remove(0);
                deck2.remove(0);
                sum1 += pl2card;
                sum2 -= pl2card;
            } else if(pl2card > pl1card){
                deck2.add(pl2card);
                deck2.add(pl1card);
                deck2.remove(0);
                deck1.remove(0);
                sum2 += pl1card;
                sum1 -= pl1card;
            } else {
                deck1.remove(0);
                deck2.remove(0);
                sum1 -= pl1card;
                sum2 -= pl2card;
            }
            if(deck1.size() == 0 || deck2.size() == 0){
                if( deck1.size()!=0){
                    System.out.printf("First player wins! Sum: %d",sum1);
                } else {
                    System.out.printf("Second player wins! Sum: %d",sum2);
                }
                break;
            }
        }
    }
}
