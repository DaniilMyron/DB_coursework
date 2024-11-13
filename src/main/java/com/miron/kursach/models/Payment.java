package com.miron.kursach.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int salary;
    private String name;
    @JoinColumn(name = "cashier_id", unique = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Cashier cashier;

    public Payment() {
    }

    public Payment(int salary, String name, Cashier cashier) {
        this.salary = salary;
        this.name = name;
        this.cashier = cashier;
    }
}
