import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = scan.nextLine();
        String regex = "(@|#)(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputLine);
        int counter = 0;
        List<String> firstWords = new ArrayList<>();
        List<String> secondWords = new ArrayList<>();
        while (matcher.find()) {
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            counter++;
            if (firstWord.length() == secondWord.length()) {
                if (wordsAreMirror(firstWord, secondWord)) {
                    firstWords.add(firstWord);
                    secondWords.add(secondWord);
                }
            }

        }
        if(counter == 0){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.printf("%d word pairs found!%n",counter);
            if(firstWords.isEmpty()){
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                for (int i = 0; i < firstWords.size(); i++) {
                    if(i == firstWords.size() - 1){
                        System.out.printf("%s <=> %s",firstWords.get(i), secondWords.get(i));
                    } else {
                        System.out.printf("%s <=> %s, ",firstWords.get(i), secondWords.get(i));
                    }

                }
            }
        }

    }

    private static boolean wordsAreMirror(String firstWord, String secondWord) {
        boolean characterMatch = true;
        for (int i = 0; i < firstWord.length(); i++) {
            if(firstWord.charAt(i) != secondWord.charAt(secondWord.length() - 1 - i)){
                characterMatch = false;
                break;
            }

        }
        if(characterMatch){
            return true;
        }
        return false;
    }

}