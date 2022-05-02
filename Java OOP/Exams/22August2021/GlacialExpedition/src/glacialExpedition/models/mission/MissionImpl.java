package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MissionImpl implements Mission {

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List <String> list = new ArrayList<>(state.getExhibits());
        for (Explorer explorer : explorers) {
            while(explorer.canSearch()){
                if(state.getExhibits().isEmpty()){
                    return;
                } else {
                    explorer.search();
                    explorer.getSuitcase().getExhibits().add(list.get(0));
                    list.remove(0);
                }


            }
        }


    }
}
