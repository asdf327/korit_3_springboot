package com.packt.cardatabase.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerid;

    private String firstname, lastname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") //컬럼명 owner를 참조하여 ownerid에 맞는 자동차 목록을 가져옴
    private List<Car> cars; //한 명이 여러 개의 차를 가질 수 있으니 필드로 만듬

    public Owner() {
    }

    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
