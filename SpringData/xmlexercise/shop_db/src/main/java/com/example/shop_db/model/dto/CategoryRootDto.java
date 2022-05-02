package com.example.shop_db.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRootDto {
    @XmlElement(name = "category")
    List<CategoryViewDto> categories;

    public CategoryRootDto() {
    }

    public List<CategoryViewDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryViewDto> categories) {
        this.categories = categories;
    }
}
