package com.packt.cardatabase.domain;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand, model, color, registrationNumber;

    private int modelYear, price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner") //조인할 때 쓸 컬럼인데 컬럼명을 owner오 짓는다는 의미
    private Owner owner;
    //@JoinColumn만 사용하게 될 경우 하이버네이트에서 마음대로 pk_fk 형태로 임의의 컬럼명을 작성함 - ownerid

    public Car() {}

    public Car(String brand, String model, String color, String registrationNumber, int modelYear, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getPrice() {
        return price;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }
}
