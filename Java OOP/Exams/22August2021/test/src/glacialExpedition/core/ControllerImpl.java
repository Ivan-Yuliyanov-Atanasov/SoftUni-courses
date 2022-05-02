package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.exploredStates = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        if (!type.equals("AnimalExplorer") && !type.equals("GlacierExplorer") && !type.equals("NaturalExplorer")) {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        } else {
            Explorer explorer;
            if(type.equals("AnimalExplorer")){
                explorer = new AnimalExplorer(explorerName);
            } else if (type.equals("GlacierExplorer")){
                explorer = new GlacierExplorer(explorerName);
            } else {
                explorer = new NaturalExplorer(explorerName);
            }
            this.explorerRepository.getCollection().add(explorer);

            return String.format(EXPLORER_ADDED,type,explorerName);
        }
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        stateRepository.add(state);
        return String.format(STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        boolean successfulRemove = explorerRepository.getCollection().removeIf(e -> e.getName().equals(explorerName));
        if (!successfulRemove){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
        }

        return String.format(EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        List<Explorer> suitableExplorers = explorerRepository.getCollection().
                stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (suitableExplorers.isEmpty()){
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        State currentState = null;
        for (State s : stateRepository.getCollection()) {
            if (s.getName().equals(stateName)){
                currentState = s;
                break;
            }

        }
        mission.explore(currentState,suitableExplorers);
        exploredStates++;
        List<Explorer> retiredExplorers = suitableExplorers.stream().filter(e -> e.getEnergy() == 0).collect(Collectors.toList());
        return String.format(STATE_EXPLORER,stateName, retiredExplorers.size());
    }

    @Override
    public String finalResult() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d states were explored.",exploredStates)).append(System.lineSeparator());
        output.append("Information for the explorers:").append(System.lineSeparator());
        for (Explorer explorer : explorerRepository.getCollection()) {
            output.append(explorer.toString()).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
