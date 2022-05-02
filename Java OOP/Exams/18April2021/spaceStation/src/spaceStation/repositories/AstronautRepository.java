package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    //    private Map<String, Astronaut> astronauts;
    private Collection<Astronaut> astronauts;

    public AstronautRepository() {
//        this.astronauts = new LinkedHashMap<>();
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
//        return Collections.unmodifiableCollection(this.astronauts.values());
        return Collections.unmodifiableCollection(this.astronauts);
    }

    @Override
    public void add(Astronaut model) {
//        this.astronauts.put(model.getName(),model);
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
//        return this.astronauts.values().removeIf(a -> a.getName().equals(model.getName()));
        return this.astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        for (Astronaut astronaut : astronauts) {
            if (astronaut.getName().equals(name)){
                return astronaut;
            }
        }
//        return this.astronauts.get(name);
        return null;
    }
}
