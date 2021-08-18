import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MOBA_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, TreeMap<String,Integer>> players = new TreeMap<>();
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Season end")){
            if(!inputLine.contains(" vs ")){
                String [] tokens = inputLine.split(" -> ");
                String name = tokens [0];
                String position = tokens [1];
                Integer skill = Integer.parseInt(tokens [2]);
                TreeMap<String, Integer> player = new TreeMap<>();
                players.putIfAbsent(name,player);
                if(!players.get(name).containsKey(position)){
                    players.get(name).put(position,skill);
                } else {
                    if(players.get(name).get(position) < skill){
                        players.get(name).put(position,skill);
                    }
                }
            } else {
                String [] playerNames = inputLine.split(" vs ");
                String playerOne = playerNames[0];
                String playerTwo = playerNames[1];
                if(players.containsKey(playerOne) && players.containsKey(playerTwo)){
                    if(isCommon(players.get(playerOne).keySet(),players.get(playerTwo).keySet())){
                        int playerOneTotalSkill = players.get(playerOne).values().stream().mapToInt(e->e).sum();
                        int playerTwoTotalSkill = players.get(playerTwo).values().stream().mapToInt(e->e).sum();
                        if(playerOneTotalSkill > playerTwoTotalSkill){
                            players.remove(playerTwo);
                        } else if(playerOneTotalSkill < playerTwoTotalSkill){
                            players.remove(playerOne);
                        }
                    }
                }
            }

            inputLine = scan.nextLine();
        }
        players.entrySet().stream()
                .sorted((p1,p2)->Integer.compare(p2.getValue().values().stream().mapToInt(e->e).sum(),p1.getValue().values().stream().mapToInt(e->e).sum()))
                .forEach(p->{
                    System.out.printf("%s: %d skill%n",p.getKey(),p.getValue().values().stream().mapToInt(e->e).sum());
                    p.getValue().entrySet().stream()
                            .sorted((e1,e2)->Integer.compare(e2.getValue(),e1.getValue()))
                            .forEach(e-> System.out.printf("- %s <::> %d%n",e.getKey(),e.getValue()));
                });
    }

    private static boolean isCommon(Set<String> keySet, Set<String> keySet1) {
        for(String s1 : keySet){
            for (String s2 : keySet1){
                if(s1.equals(s2)){
                    return true;
                }
            }
        }
        return false;
    }
}
