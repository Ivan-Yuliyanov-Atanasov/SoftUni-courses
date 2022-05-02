package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        if(!type.equals("LongHouse") && !type.equals("ShortHouse")){
            throw new IllegalArgumentException(INVALID_HOUSE_TYPE);
        }
        House house;
        if(type.equals("LongHouse")){
            house = new LongHouse(name);
        } else {
            house = new ShortHouse(name);
        }
        houses.put(name,house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        if(!type.equals("Mouse") && !type.equals("Ball")){
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        Toy toy;
        if(type.equals("Mouse")){
            toy = new Mouse();
        } else {
           toy = new Ball();
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        if(toys.findFirst(toyType) == null){
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND,toyType));

        }
        Toy toy = toys.findFirst(toyType);
        this.toys.removeToy(toy);
        this.houses.get(houseName).buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {

        if(!catType.equals("LonghairCat") && !catType.equals("ShorthairCat")){
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        Cat cat;
        if(catType.equals("LonghairCat")){
            cat = new LonghairCat(catName,catBreed,price);
        } else {
            cat = new ShorthairCat(catName,catBreed,price);
        }
        String catSubstring = catType.substring(0,3);
        String houseSubstring = this.houses.get(houseName).getClass().getSimpleName().substring(0,3);
        if(catSubstring.equals(houseSubstring)){
            this.houses.get(houseName).addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE,catType,houseName);
        }

        return UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        int size = this.houses.get(houseName).getCats().size();
        this.houses.get(houseName).getCats().forEach(Cat::eating);
        return String.format(FEEDING_CAT,size);
    }

    @Override
    public String sumOfAll(String houseName) {
        double sum = this.houses.get(houseName).getCats().stream().mapToDouble(Cat::getPrice).sum() +
                this.houses.get(houseName).getToys().stream().mapToDouble(Toy::getPrice).sum();

        return String.format(VALUE_HOUSE,houseName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder report = new StringBuilder();
        Collection<House> list = this.houses.values();
        for (House house : list) {
            report.append(house.getStatistics()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
