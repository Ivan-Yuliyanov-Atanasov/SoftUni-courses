package exam.model.dto;


import java.math.BigDecimal;

public class ExportDTO {


    private String macAddress;

    private Double cpuSpeed;

    private Integer ram;

    private Integer storage;

    private BigDecimal price;

    private String shopName;

    private String townName;

    public ExportDTO(String macAddress, Double cpuSpeed, Integer ram, Integer storage, BigDecimal price, String shopName, String townName) {
        this.macAddress = macAddress;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
        this.shopName = shopName;
        this.townName = townName;

    }

    public String getMacAddress() {
        return macAddress;
    }

    public ExportDTO setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public ExportDTO setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
        return this;
    }

    public Integer getRam() {
        return ram;
    }

    public ExportDTO setRam(Integer ram) {
        this.ram = ram;
        return this;
    }

    public Integer getStorage() {
        return storage;
    }

    public ExportDTO setStorage(Integer storage) {
        this.storage = storage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ExportDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public ExportDTO setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public String getTownName() {
        return townName;
    }

    public ExportDTO setTownName(String townName) {
        this.townName = townName;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Laptop - %s\n*Cpu speed - %.2f\n**Ram - %d\n***Storage - " +
                "%d\n****Price - %s\n#Shop name - %s\n##Town - " +
                "%s\n\n",this.macAddress, this.cpuSpeed, this.ram, this.storage, this.price, this.shopName, this.townName);
    }
}
