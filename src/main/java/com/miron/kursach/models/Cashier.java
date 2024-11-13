package com.miron.kursach.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cashiers")
public class Cashier extends Person implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cinemaName;
    private String address;
    private boolean isOnDuty;

    public Cashier(String name, String surname, String patronymic, String phoneNumber, String cinemaName, String address, boolean isOnDuty) {
        super(name, surname, patronymic, phoneNumber);
        this.cinemaName = cinemaName;
        this.address = address;
        this.isOnDuty = isOnDuty;
    }

    public Cashier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }
}
