package exam.model.dto;

import com.google.gson.annotations.Expose;


import exam.model.entity.enums.WarrantyType;


import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopImportDTO {

    @Expose
    @NotNull
    @Size(min = 9)
    private String macAddress;

    @Expose
    @NotNull
    @Positive
    private Double cpuSpeed;

    @Expose
    @NotNull
    @Min(8)
    @Max(128)
    private Integer ram;

    @Expose
    @NotNull
    @Min(128)
    @Max(1024)
    private Integer storage;

    @Expose
    @NotNull
    @Positive
    private BigDecimal price;

    @Expose
    @NotNull
    @Size(min = 10)
    private String description;

    @Expose
    @NotNull
    private WarrantyType warrantyType;

    @Expose
    @NotNull
    private ShopImportDTO shop;

    public LaptopImportDTO() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public LaptopImportDTO setMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public LaptopImportDTO setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
        return this;
    }

    public Integer getRam() {
        return ram;
    }

    public LaptopImportDTO setRam(Integer ram) {
        this.ram = ram;
        return this;
    }

    public Integer getStorage() {
        return storage;
    }

    public LaptopImportDTO setStorage(Integer storage) {
        this.storage = storage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LaptopImportDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LaptopImportDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public LaptopImportDTO setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
        return this;
    }

    public ShopImportDTO getShop() {
        return shop;
    }

    public LaptopImportDTO setShop(ShopImportDTO shop) {
        this.shop = shop;
        return this;
    }
}
