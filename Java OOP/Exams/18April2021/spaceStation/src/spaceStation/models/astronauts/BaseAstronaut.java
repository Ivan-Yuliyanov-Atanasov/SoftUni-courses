package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {

//        return this.oxygen >= 10;
        return this.oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
//        this.oxygen -= 10;
//        if (this.oxygen <= 0) {
//            this.oxygen = 0;
//        }
        this.oxygen -= 10;
        if (!canBreath()){
            this.setOxygen(0);
        }

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(REPORT_ASTRONAUT_NAME, name)).append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_OXYGEN, oxygen)).append(System.lineSeparator())
                .append("Bag items: ");
        if (this.bag.getItems().isEmpty()) {
            output.append("none");
        } else {
            output.append(this.bag.getItems().toString().replace("[", "").replace("]", ""));
        }
        return output.toString().trim();
    }
}
