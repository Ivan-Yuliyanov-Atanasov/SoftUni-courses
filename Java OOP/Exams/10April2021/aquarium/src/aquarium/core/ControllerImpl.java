package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.put(aquariumName, aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        this.decorations.remove(decoration);
        this.aquariums.get(aquariumName).addDecoration(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {

        if (!fishType.equals("SaltwaterFish") && !fishType.equals("FreshwaterFish")) {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        String outputMessage = "";
        Fish fish;
        Aquarium aquarium = this.aquariums.get(aquariumName);
        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        }

        if (!aquarium.getClass().getSimpleName().substring(0,9).equals(fishType.substring(0,9))){
            outputMessage = WATER_NOT_SUITABLE;
        } else {
            try {
                aquarium.addFish(fish);
            } catch (IllegalStateException ex){
                return ex.getMessage();
            }
            outputMessage = String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType, aquariumName);
        }

        return outputMessage;


    }

    @Override
    public String feedFish(String aquariumName) {
        this.aquariums.get(aquariumName).feed();
        return String.format(FISH_FED, this.aquariums.get(aquariumName).getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        double fishValue = this.aquariums.get(aquariumName).getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationsValue = this.aquariums.get(aquariumName).getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double total = fishValue + decorationsValue;
        return String.format(VALUE_AQUARIUM, aquariumName, total);
    }

    @Override
    public String report() {

//        StringBuilder report = new StringBuilder();
//        for (Aquarium aquarium : aquariums.values()) {
//            report.append(aquarium.getInfo()).append(System.lineSeparator());
//        }
//        return report.toString().trim();
        return this.aquariums.values().stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
