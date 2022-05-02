package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component{

    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance,int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }


    @Override
    public String toString() {
        return String.format("Overall Performance: %.02f. Price: %.02f - %s: %s %s (Id: %d) Generation: %d%n",
                getOverallPerformance(),getPrice(),getClass().getSimpleName(),getManufacturer(),getModel(),getId(),generation);
    }

    @Override
    public int getGeneration() {
        return generation;
    }

}
