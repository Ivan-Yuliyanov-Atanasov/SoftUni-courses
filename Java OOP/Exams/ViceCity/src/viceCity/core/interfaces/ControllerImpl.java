package viceCity.core.interfaces;

import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;


import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Map<String, Player> players;
    private ArrayDeque<Gun> guns;
    private MainPlayer mainPlayer;

    public ControllerImpl() {
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.mainPlayer = new MainPlayer();
    }

    @Override
    public String addPlayer(String name) {

        Player player = new CivilPlayer(name);
        players.put(name, player);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {

        switch (type) {
            case "Pistol":
                Gun gun = new Pistol(name);
                guns.offer(gun);
                break;
            case "Rifle":
                Gun rifle = new Rifle(name);
                guns.offer(rifle);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        String output = null;

        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        } else {
            if (name.equals("Vercetti")) {
                Gun gun = guns.poll();
                mainPlayer.getGunRepository().add(gun);
                output = String.format(GUN_ADDED_TO_MAIN_PLAYER,gun.getName(),mainPlayer.getName());
            } else {
                if(!players.containsKey(name)){
                    output = CIVIL_PLAYER_DOES_NOT_EXIST;
                } else {
                    Gun gun = guns.poll();
                    players.get(name).getGunRepository().add(gun);
                    output = String.format(GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(),name);
                }
            }
        }

        return output;
    }

    @Override
    public String fight() {

        Neighbourhood neighbourhood = new GangNeighbourhood();
        neighbourhood.action(mainPlayer,players.values());
        StringBuilder report = new StringBuilder();
        List<Player> deadCivilPlayers = players.values().stream().filter(p-> !p.isAlive()).collect(Collectors.toList());
        if (mainPlayer.getLifePoints() == 100 && deadCivilPlayers.size() == 0){
            report.append(FIGHT_HOT_HAPPENED);
        } else {
           report.append(FIGHT_HAPPENED).append(System.lineSeparator())
                   .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints())).append(System.lineSeparator())
                   .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadCivilPlayers.size())).append(System.lineSeparator())
                   .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,(players.values().size()) - deadCivilPlayers.size()));
        }
        return report.toString().trim();
    }
}
