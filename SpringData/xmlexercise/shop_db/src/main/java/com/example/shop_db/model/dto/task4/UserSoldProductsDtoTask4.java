package com.example.shop_db.model.dto.task4;



import javax.xml.bind.annotation.*;


@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductsDtoTask4 {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private Integer age;
    @XmlElement(name = "sold-products")
    private SoldProductDtoTask4 soldProductDto;

    public UserSoldProductsDtoTask4() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SoldProductDtoTask4 getSoldProductDto() {
        return soldProductDto;
    }

    public void setSoldProductDto(SoldProductDtoTask4 soldProductDto) {
        this.soldProductDto = soldProductDto;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
