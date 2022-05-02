package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field{
    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream().filter(p->p.getClass().getSimpleName().equals("Terrorist")).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream().filter(p->p.getClass().getSimpleName().equals("CounterTerrorist")).collect(Collectors.toList());
        while(!terrorists.isEmpty() && !counterTerrorists.isEmpty()){

            for (Player currentTerrorist : terrorists) {

                for (Player currentCounterTerrorist : counterTerrorists) {
                    int fire = currentTerrorist.getGun().fire();
                    currentCounterTerrorist.takeDamage(fire);
                }

            }

            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());


            for (Player currentCounterTerrorist : counterTerrorists) {

                for (Player currentTerrorist : terrorists) {
                    int fire = currentCounterTerrorist.getGun().fire();
                    currentTerrorist.takeDamage(fire);
                }

            }

            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
        }

        String outputMessage = "";
        if(!terrorists.isEmpty()){
            outputMessage = TERRORIST_WINS;
        } else {
            outputMessage = COUNTER_TERRORIST_WINS;
        }

        return outputMessage;
    }
}
