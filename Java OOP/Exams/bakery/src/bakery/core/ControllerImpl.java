package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.*;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalSum = 0;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addFood(String type, String name, double price) {
        if (foodRepository.getAll().stream().anyMatch(f -> f.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        BakedFood food;
        if (type.equals("Bread")) {
            food = new Bread(name, price);
        } else {
            food = new Cake(name, price);
        }
        this.foodRepository.add(food);
        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        if (drinkRepository.getAll().stream().anyMatch(f -> f.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        Drink drink;
        if (type.equals("Water")) {
            drink = new Water(name, portion, brand);
        } else {
            drink = new Tea(name, portion, brand);
        }
        this.drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);

    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getAll().stream().anyMatch(f -> f.getTableNumber() == tableNumber)) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        Table table;
        if (type.equals("OutsideTable")) {
            table = new OutsideTable(tableNumber, capacity);
        } else {
            table = new InsideTable(tableNumber, capacity);
        }
        this.tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved() && table.getCapacity() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        if (this.tableRepository.getAll().stream().noneMatch(t -> t.getTableNumber() == tableNumber && t.isReserved())) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.foodRepository.getAll().stream().noneMatch(f-> f.getName().equals(foodName))){
            return String.format(NONE_EXISTENT_FOOD,foodName);
        }
        Table table = null;
        BakedFood food = null;
        for (Table currentTable : this.tableRepository.getAll()) {
            if (currentTable.getTableNumber() == tableNumber) {
                table = currentTable;
            }
        }
        for (BakedFood currentFood : this.foodRepository.getAll() ) {
            if(currentFood.getName().equals(foodName)){
                food = currentFood;
            }
        }

        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL,tableNumber,foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        if (this.tableRepository.getAll().stream().noneMatch(t -> t.getTableNumber() == tableNumber && t.isReserved())) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.drinkRepository.getAll().stream().noneMatch(f-> f.getName().equals(drinkName) && f.getBrand().equals(drinkBrand))){
            return String.format(NON_EXISTENT_DRINK,drinkName,drinkBrand);
        }
        Table table = tableRepository.getByNumber(tableNumber);
        Drink drink = drinkRepository.getByNameAndBrand(drinkName,drinkBrand);


        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL,tableNumber,drinkName,drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        table.clear();
        totalSum += bill;
        return String.format(BILL,tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder report = new StringBuilder();
        this.tableRepository.getAll().stream().filter(t-> !t.isReserved()).forEach(t-> report.append(t.getFreeTableInfo()));
        return report.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME,totalSum);
    }
}


