package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ExceptionMessages.*;

public abstract class BaseExplorer implements Explorer {

    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();

    }

    protected void setEnergy(double energy){
        if (energy < 0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }


    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return this.energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        this.energy -= 15;
        if (!canSearch()){
            this.setEnergy(0);
        }

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s",name)).append(System.lineSeparator());
        output.append(String.format("Energy: %.0f",energy)).append(System.lineSeparator());

       if(suitcase.getExhibits().isEmpty()){
           output.append("Suitcase exhibits: None");
       } else {
           String toJoin = suitcase.getExhibits().toString().replace("[", "").replace("]", "");
           output.append("Suitcase exhibits: ").append(toJoin);
       }
        return output.toString();
    }
}
