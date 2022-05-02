package onlineShop.models.products;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseProduct implements Product{

    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        this.setId(id);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setOverallPerformance(overallPerformance);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getOverallPerformance() {
        return overallPerformance;
    }

    @Override
    public String toString() {
        return String.format("Overall Performance: %.02f. Price: %.02f - %s: %s %s (Id: %d)%n",
                overallPerformance,price,getClass().getSimpleName(),manufacturer,model,id);
    }

    public void setId(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException(INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        if(manufacturer == null || manufacturer.trim().isEmpty()){
            throw  new IllegalArgumentException(INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        if(model == null || model.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_MODEL);
        }
        this.model = model;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setOverallPerformance(double overallPerformance) {
        if(overallPerformance <= 0){
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }
}