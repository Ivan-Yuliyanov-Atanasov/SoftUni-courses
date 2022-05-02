package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    Map<Integer,Computer> computers;
    Map<Integer, Peripheral> peripherals;
    Map<Integer, Component> components;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
        this.peripherals = new LinkedHashMap<>();
        this.components = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if(computers.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        if(!computerType.equals("DesktopComputer") && !computerType.equals("Laptop")){
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        Computer computer;
        if(computerType.equals("DesktopComputer")){
            computer = new DesktopComputer(id,manufacturer,model,price);
        } else {
            computer = new Laptop(id, manufacturer, model, price);
        }
        computers.put(id,computer);
        return String.format(ADDED_COMPUTER,id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        checkIfComputerWithThatIdExists(computerId);
        if(peripherals.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        if(!peripheralType.equals("Headset") && !peripheralType.equals("Keyboard") && !peripheralType.equals("Mouse") && !peripheralType.equals("Monitor")){
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        Peripheral peripheral = null;
        switch (peripheralType){
            case "Mouse":
                peripheral = new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Headset":
                peripheral = new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
                break;

        }
        peripherals.put(id,peripheral);
        computers.get(computerId).addPeripheral(peripheral);
        return String.format(ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkIfComputerWithThatIdExists(computerId);

        Peripheral peripheral = null;
        for (Peripheral currentPeripheral : peripherals.values()) {
            if(currentPeripheral.getClass().getSimpleName().equals(peripheralType)){
                peripheral = currentPeripheral;
                break;

            }
        }
        if (peripheral != null) {
            int id = peripheral.getId();
            computers.get(computerId).removePeripheral(peripheralType);
            peripherals.remove(id);
            return String.format(REMOVED_PERIPHERAL,peripheralType, id);
        }
        return String.format("Peripheral %s does not exist in Laptop with Id %d.",peripheralType,computerId);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        checkIfComputerWithThatIdExists(computerId);
        if(components.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        if(!componentType.equals("CentralProcessingUnit") && !componentType.equals("Motherboard") && !componentType.equals("PowerSupply")
                && !componentType.equals("RandomAccessMemory") && !componentType.equals("SolidStateDrive") && !componentType.equals("VideoCard")  ){
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        Component component = null;
        switch (componentType){
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "Motherboard":
                component = new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "VideoCard":
                component = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
                break;

        }
        components.put(id,component);
        computers.get(computerId).addComponent(component);
        return String.format(ADDED_COMPONENT,componentType,id,computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {


        checkIfComputerWithThatIdExists(computerId);

        Component component = null;
        for (Component currentComponent : components.values()) {
            if(currentComponent.getClass().getSimpleName().equals(componentType)){
                component = currentComponent;
                break;

            }
        }
        if (component != null) {
            int id = component.getId();
            computers.get(computerId).removeComponent(componentType);
            components.remove(id);
            return String.format(REMOVED_COMPONENT,componentType, id);
        }
        return String.format("Component %s does not exist in Laptop with Id %d.",componentType,computerId);

    }

    @Override
    public String buyComputer(int id) {
        checkIfComputerWithThatIdExists(id);
        Computer removedComputer = computers.remove(id);
        return removedComputer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        if(computers.isEmpty() || computers.values().stream().noneMatch(c-> c.getPrice() <= budget)){
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }
        List<Computer> computerSorted = computers.values().stream().filter(c -> c.getPrice() <= budget)
                .sorted(Comparator.comparingDouble(Product::getOverallPerformance))
                .collect(Collectors.toList());

        Computer computer = computerSorted.get(0);
        int id = computer.getId();
        computers.remove(id);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        checkIfComputerWithThatIdExists(id);
        Computer computer = computers.get(id);
        return computer.toString();
    }

    private void checkIfComputerWithThatIdExists(int id){
        if(!computers.containsKey(id)){
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }

}
