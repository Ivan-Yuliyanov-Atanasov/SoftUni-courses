import java.util.*;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> pieces = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            ArrayList<String> composerKey = new ArrayList<>();
            composerKey.add(composer);
            composerKey.add(key);
            pieces.put(piece,composerKey);

        }
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Stop")){
            String[] newTokens = inputLine.split("\\|");
            String command = newTokens[0];
            switch (command){
                case "Add":
                    if(pieces.containsKey(newTokens[1])){
                        System.out.printf("%s is already in the collection!%n",newTokens[1]);
                    } else {
                        ArrayList<String> composerKey = new ArrayList<>();
                        composerKey.add(newTokens[2]);
                        composerKey.add(newTokens[3]);
                        pieces.put(newTokens[1],composerKey);
                        System.out.printf("%s by %s in %s added to the collection!%n",newTokens[1],newTokens[2],newTokens[3]);
                    }
                    break;
                case "Remove":
                    if(pieces.containsKey(newTokens[1])){
                        pieces.remove(newTokens[1]);
                        System.out.printf("Successfully removed %s!%n",newTokens[1]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",newTokens[1]);
                    }
                    break;
                case "ChangeKey":
                    if(pieces.containsKey(newTokens[1])){
                        pieces.get(newTokens[1]).set(1,newTokens[2]);
                        System.out.printf("Changed the key of %s to %s!%n",newTokens[1],newTokens[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",newTokens[1]);
                    }
                    break;
            }
            inputLine = scan.nextLine();
        }
//        pieces.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
//                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
        pieces.entrySet().stream()
                .forEach(entry ->{

                    System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(),entry.getValue().get(0),entry.getValue().get(1));
                });

    }
}
