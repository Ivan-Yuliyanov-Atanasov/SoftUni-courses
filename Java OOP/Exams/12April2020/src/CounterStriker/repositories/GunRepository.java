package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun>{

    private Map<String,Gun> models;

    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return models.values();
    }

    @Override
    public void add(Gun model) {
        if(model == null){
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.put(model.getName(),model);

    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model.getName(),model);

    }

    @Override
    public Gun findByName(String name) {
        if(models.containsKey(name)){
            return models.get(name);
        }
        return null;
    }
}
