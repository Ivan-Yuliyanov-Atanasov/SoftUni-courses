package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller{

    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if(!type.equals("Pistol") && !type.equals("Rifle")){
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        Gun gun;
        if(type.equals("Pistol")){
            gun = new Pistol(name, bulletsCount);
        } else {
            gun = new Rifle(name,bulletsCount);
        }
        guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN,name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.findByName(gunName);
        if(gun == null){
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        if(!type.equals("Terrorist") && !type.equals("CounterTerrorist")){
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        Player player;

        if(type.equals("Terrorist")){
            player = new Terrorist(username, health, armor,gun);
        } else {
            player = new CounterTerrorist(username, health, armor , gun);
        }
        players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER,username);

    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        players.getModels().stream().sorted((p1,p2)->{
            int result = p1.getClass().getSimpleName().compareTo(p2.getClass().getSimpleName());
            if(result == 0){
                result = Integer.compare(p2.getHealth(),p1.getHealth());
                if(result == 0){
                    result = p1.getUsername().compareTo(p2.getUsername());
                }
            }
            return result;
        }).forEach(p-> report.append(p.toString()));
        return report.toString().trim();
    }

}
