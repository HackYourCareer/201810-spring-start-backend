package com.sap.hack.your.career.springdemo.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Simple entity with validation of fields
 */
@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;
    private String description;

    @Range(min = 0, max = 100)
    private Float alcoholContent;

    @Min(0)
    @Max(100)
    private Integer idu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(Float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public Integer getIdu() {
        return idu;
    }

    public void setIdu(Integer idu) {
        this.idu = idu;
    }
}
