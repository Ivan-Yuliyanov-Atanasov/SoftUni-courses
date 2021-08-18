import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String winningRegex = "[\\$]{6,}|[@]{6,}|[#]{6,}|[\\^]{6,}";
        String jackpotRegex = "[\\$]{20}|[@]{20}|[#]{20}|[\\^]{20}";
        String[] tickets = scan.nextLine().split(",\\s*");
        Pattern winningPattern = Pattern.compile(winningRegex);
        Pattern jackpotPattern = Pattern.compile(jackpotRegex);

        for (int i = 0; i < tickets.length; i++) {
            String ticket = tickets[i].trim();
            if(ticket.length() == 20){
                String firstHalf = ticket.substring(0,10);
                String secondHalf = ticket.substring(10);
                Matcher jackpotMatcher = jackpotPattern.matcher(ticket);
                Matcher winningMatcherFirstHalf = winningPattern.matcher(firstHalf);
                Matcher winningMatcherSecondHalf = winningPattern.matcher(secondHalf);
                if(jackpotMatcher.find()){
                    char jackpotSign = jackpotMatcher.group().charAt(0);
                    System.out.printf("ticket \"%s\" - 10%c Jackpot!%n",ticket,jackpotSign);
                } else {
                    if(winningMatcherFirstHalf.find() && winningMatcherSecondHalf.find()){
                        char winningSign = winningMatcherFirstHalf.group().charAt(0);
                        int count = Math.min((winningMatcherFirstHalf.group()).length(),(winningMatcherSecondHalf.group()).length());
                        System.out.printf("ticket \"%s\" - %d%c%n",ticket,count,winningSign);

                    } else {
                        System.out.printf("ticket \"%s\" - no match%n",ticket);
                    }
                }

            } else {
                System.out.println("invalid ticket");
            }

        }

    }
}
