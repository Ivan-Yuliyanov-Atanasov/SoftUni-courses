package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;
import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_REPOSITORY;

public class PlayerRepository implements Repository<Player> {

    private Map<String, Player> models;

    public PlayerRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Player> getModels() {
        return models.values();
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        models.put(model.getUsername(), model);

    }

    @Override
    public boolean remove(Player model) {
        return models.remove(model.getUsername(), model);
    }

    @Override
    public Player findByName(String name) {
        if (models.containsKey(name)) {
            return models.get(name);
        }
        return null;

    }
}
