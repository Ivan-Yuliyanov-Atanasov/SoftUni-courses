package hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class TownImportDTO {

    @Expose
    @NotNull
    private String name;

    @Expose
    @NotNull
    private Integer population;

    public String getName() {
        return name;
    }

    public TownImportDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public TownImportDTO setPopulation(Integer population) {
        this.population = population;
        return this;
    }
}
