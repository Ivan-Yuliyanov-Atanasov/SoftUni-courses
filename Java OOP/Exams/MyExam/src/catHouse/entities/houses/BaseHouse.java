package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.*;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private List<Toy> toys;
    private List<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() == this.capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%s %s:", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        report.append("Cats: ");
        if (this.cats.isEmpty()) {
            report.append("none");
        } else {
            for (int i = 0; i < this.cats.size(); i++) {
                if (i == this.cats.size() - 1) {
                    report.append(this.cats.get(i).getName());
                } else {
                    report.append(this.cats.get(i).getName() + " ");
                }

            }
        }
        report.append(System.lineSeparator());
        report.append(String.format("Toys: %d Softness: %d",toys.size(),this.toys.stream().mapToInt(Toy::getSoftness).sum()));

        return report.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;

    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
