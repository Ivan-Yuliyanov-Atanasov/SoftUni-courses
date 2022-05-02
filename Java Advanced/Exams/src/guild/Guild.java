package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player currentPlayer : roster) {
            if (currentPlayer.getName().equals(name) && !currentPlayer.getRank().equals("Member")) {
                currentPlayer.setRank("Member");
                break;
            }

        }
    }

    public void demotePlayer(String name) {
        for (Player currentPlayer : roster) {
            if (currentPlayer.getName().equals(name) && !currentPlayer.getRank().equals("Trial")) {
                currentPlayer.setRank("Trial");
                break;
            }

        }
    }

    public int count() {
        return this.roster.size();
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        for (int i = 0; i < this.roster.size(); i++) {
            Player currentPlayer = this.roster.get(i);
            if (currentPlayer.getClazz().equals(clazz)){
                kickedPlayers.add(currentPlayer);
                this.roster.remove(currentPlayer);
                i--;
            }

        }
        Player[] arr = new Player[kickedPlayers.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kickedPlayers.get(i);

        }
        return arr;
    }
    public String report(){
        StringBuilder report = new StringBuilder();
        report.append(String.format("Players in the guild: %s:",this.name)).append(System.lineSeparator());
        for (Player player : roster) {
            report.append(player).append(System.lineSeparator());

        }
        return report.toString();
    }

}
