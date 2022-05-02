package onlineShop.models.products.peripherals;

import onlineShop.models.products.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {

    private String connectionType;

    protected BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return String.format("Overall Performance: %.02f. Price: %.02f - %s: %s %s (Id: %d) Connection Type: %s%n",
                getOverallPerformance(),getPrice(),getClass().getSimpleName(),getManufacturer(),getModel(),getId(),connectionType);
    }
}
