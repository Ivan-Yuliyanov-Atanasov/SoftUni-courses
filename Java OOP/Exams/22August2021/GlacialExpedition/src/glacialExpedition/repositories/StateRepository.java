package glacialExpedition.repositories;


import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateRepository implements Repository <State> {

    private List<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }


    @Override
    public Collection<State> getCollection() {
        return states;
    }

    @Override
    public void add(State state) {
        this.states.add(state);

    }

    @Override
    public boolean remove(State state) {
        return this.states.remove(state);
    }

    @Override
    public State byName(String name) {
        return this.states.stream().findFirst().orElse(null);
    }
}

