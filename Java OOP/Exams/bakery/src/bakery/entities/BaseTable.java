package bakery.entities;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }


    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return this.numberOfPeople * this.pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {

        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReserved = true;

    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);

    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        return getPrice() + this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum() + this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
    }

    @Override
    public void clear() {
        this.foodOrders.clear();
        this.drinkOrders.clear();
        this.numberOfPeople = 0;
        this.isReserved = false;
        this.price = 0;

    }

    @Override
    public String getFreeTableInfo() {
        return String.format("Table: %d%n" +
                "Type: %s%n" +
                "Capacity: %d%n" +
                "Price per Person: %.2f%n",this.tableNumber,this.getClass().getSimpleName(),this.capacity,this.pricePerPerson);
    }
}
