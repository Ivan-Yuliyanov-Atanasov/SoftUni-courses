package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        this.totalMoney = 0;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = null;
        if (type.equals("Salad")) {
            food = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
        }
        if (this.healthFoodRepository.getAllEntities().stream().anyMatch(f -> f.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        this.healthFoodRepository.add(food);
        return String.format(FOOD_ADDED, name);
    }


    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = null;
        if (type.equals("Smoothie")) {
            beverage = new Smoothie(name, counter, brand);
        } else if (type.equals("Fresh")) {
            beverage = new Fresh(name, counter, brand);
        }
        if (this.beverageRepository.getAllEntities().stream().anyMatch(b -> b.getName().equals(name))) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
        this.beverageRepository.add(beverage);
        return String.format(BEVERAGE_ADDED, beverage.getClass().getSimpleName(), brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (type.equals("Indoors")) {
            table = new Indoors(tableNumber, capacity);
        } else if (type.equals("InGarden")) {
            table = new InGarden(tableNumber, capacity);
        }
        if (this.tableRepository.getAllEntities().stream().anyMatch(t -> t.getTableNumber() == tableNumber)) {
            throw new IllegalArgumentException(String.format(String.format(TABLE_IS_ALREADY_ADDED,tableNumber)));
        }
        this.tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        for (Table table : this.tableRepository.getAllEntities()) {
            if (!table.isReservedTable() && table.getSize() >= numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }

        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);

    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        if (this.tableRepository.getAllEntities().stream().noneMatch(t -> t.getTableNumber() == tableNumber)) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.healthFoodRepository.getAllEntities().stream().noneMatch(b -> b.getName().equals(healthyFoodName))) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }
        HealthyFood food = null;
        for (HealthyFood currentFood : this.healthFoodRepository.getAllEntities()) {
            if (currentFood.getName().equals(healthyFoodName)) {
                food = currentFood;
                break;
            }
        }

        for (Table table : this.tableRepository.getAllEntities()) {
            if (table.getTableNumber() == tableNumber) {
                table.orderHealthy(food);
                break;
            }

        }
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        if (this.tableRepository.getAllEntities().stream().noneMatch(t -> t.getTableNumber() == tableNumber)) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if (this.beverageRepository.getAllEntities().stream().noneMatch(b -> b.getName().equals(name) && b.getBrand().equals(brand))) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }
        Beverages beverage = null;
        for (Beverages currentBeverage : this.beverageRepository.getAllEntities()) {
            if (currentBeverage.getName().equals(name) && currentBeverage.getBrand().equals(brand)) {
                beverage = currentBeverage;
                break;
            }
        }

        for (Table table : this.tableRepository.getAllEntities()) {
            if (table.getTableNumber() == tableNumber) {
                table.orderBeverages(beverage);
                break;
            }

        }
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        double bill = 0;
        for (Table table : this.tableRepository.getAllEntities()) {
            if (table.getTableNumber() == tableNumber) {
                bill = table.bill();
                table.clear();
                break;
            }

        }
        totalMoney += bill;

        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {

        return String.format(TOTAL_MONEY,totalMoney);
    }
}
