package footballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name.trim();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        if(players.removeIf(p -> p.getName().equals(name))){

        } else {
            System.out.printf("Player %s is not in %s team.%n",name, this.name);
        }

    }

    public double overallSkillLevel() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0.0);
    }
}
