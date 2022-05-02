package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append(super.toString());

            report.append(String.format(" Components (%d):",components.size())).append(System.lineSeparator());
            for (Component component : components) {
                report.append("  " + component);
            }


            double average = peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0.00);
            report.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):",peripherals.size(),average)).append(System.lineSeparator());
            for (Peripheral peripheral : peripherals) {
                report.append("  " + peripheral);
            }

        return report.toString().trim();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.stream().anyMatch(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);

    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty() || this.components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));
        }
        Component component = null;
        for (Component currentComponent : components) {
            if(currentComponent.getClass().getSimpleName().equals(componentType)){
                component = currentComponent;
                this.components.remove(component);
                break;

            }
        }
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.components.stream().anyMatch(c -> c.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);

    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty() || this.peripherals.stream().noneMatch(c -> c.getClass().getSimpleName().equals(peripheralType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        Peripheral peripheral = null;
        for (Peripheral currentPeripheral : peripherals) {
            if(currentPeripheral.getClass().getSimpleName().equals(peripheralType)){
                peripheral = currentPeripheral;
                this.peripherals.remove(peripheral);
                break;

            }
        }
        return peripheral;


    }

    @Override
    public double getOverallPerformance() {
        return this.components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0.0) + super.getOverallPerformance();
    }

    @Override
    public double getPrice() {
        return this.components.stream().mapToDouble(Component::getPrice).sum() +
                this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum()
                + super.getPrice();
    }

}
