package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerImpl implements Player{

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.isAlive = true;
        this.setGun(gun);
    }

    public void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if(health < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if(armor < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setGun(Gun gun) {
        if(gun == null){
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public Gun getGun() {
        return gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
    @Override
    public void takeDamage(int points) {
        if(armor - points < 0){
            int damage = Math.abs(armor - points);
            setArmor(0);
            if(health - damage < 0){
                setHealth(0);
                isAlive = false;
            } else {
                setHealth(health - damage);
            }
        } else {
            setArmor(armor - points);
        }

    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                "--Health: %d%n" +
                "--Armor: %d%n" +
                "--Gun: %s%n",getClass().getSimpleName(),username, health, armor, gun.getName());

    }
}
