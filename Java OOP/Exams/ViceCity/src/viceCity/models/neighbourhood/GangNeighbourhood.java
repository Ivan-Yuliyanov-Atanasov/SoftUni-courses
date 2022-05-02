package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {


    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        Repository<Gun> guns = mainPlayer.getGunRepository();

        for (Gun currentGun : guns.getModels()) {

            for (Player currentPlayer : civilPlayers) {
                while (currentPlayer.isAlive()) {
                    int damage = currentGun.fire();
                    currentPlayer.takeLifePoints(damage);
                    if (!currentGun.canFire()) {
                        break;
                    }
                }
            }
        }
        List<Player> aliveCivilPlayers = civilPlayers.stream().filter(Player::isAlive).collect(Collectors.toList());
        for (Player aliveCivilPlayer : aliveCivilPlayers) {
            Repository<Gun> civilPlayerUGuns = aliveCivilPlayer.getGunRepository();

            for (Gun currentGun : civilPlayerUGuns.getModels()) {
                    while (mainPlayer.isAlive()) {
                        int damage = currentGun.fire();
                        mainPlayer.takeLifePoints(damage);
                        if (!currentGun.canFire()) {
                            break;
                        }
                    }

            }

        }
    }


}
