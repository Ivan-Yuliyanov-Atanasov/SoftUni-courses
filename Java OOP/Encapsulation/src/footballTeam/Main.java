package footballTeam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Team> teams = new LinkedHashMap<>();

        String inputLine = "";
        while(!(inputLine = scanner.nextLine()).equals("END")){
            String [] tokens = inputLine.split(";");
            String command = tokens[0];
            switch (command){
                case "Team":
                    try {
                        Team team = new Team(tokens[1]);
                        teams.put(tokens[1], team);
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;

                case "Rating":
                    if(teams.containsKey(tokens[1])){
                        double test = Math.round(teams.get(tokens[1]).overallSkillLevel());
                        System.out.printf("%s - %d%n",tokens[1],Math.round(teams.get(tokens[1]).overallSkillLevel()));

                    } else {
                        System.out.printf("Team %s does not exist.%n",tokens[1]);
                    }
                    break;

                case "Add":
                    if(teams.containsKey(tokens[1])){
                        try {
                            Player player = new Player(tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7]));
                            teams.get(tokens[1]).addPlayer(player);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.printf("Team %s does not exist.%n",tokens[1]);
                    }
                    break;

                case "Remove":
                    teams.get(tokens[1]).removePlayer(tokens[2]);

                    break;
            }

        }

    }
}
