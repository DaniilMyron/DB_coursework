package com.miron.kursach.models;

import com.miron.kursach.DB_settings.TicketService;
import com.miron.kursach.HelloApplication;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cinemagoers")
public class Cinemagoer extends Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Cinemagoer(String name, String surname, String patronymic, String phoneNumber) {
        super(name, surname, patronymic, phoneNumber);
    }


    public Cinemagoer() {
    }

    public int getId() {
        return id;
    }

}
