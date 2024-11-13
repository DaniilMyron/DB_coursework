package com.miron.kursach.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "sellings")
public class Selling implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "ticket_id", unique = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Ticket ticket;
    @JoinColumn(name = "cashier_id", unique = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Cashier cashier;
    @JoinColumn(name = "cinemagoer_id", unique = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Cinemagoer cinemagoer;
    private int price;
    private String date;

    public Selling(Ticket ticket, Cashier cashier, Cinemagoer cinemagoer, int price, String date) {
        this.ticket = ticket;
        this.cashier = cashier;
        this.cinemagoer = cinemagoer;
        this.price = price;
        this.date = date;
    }

    public Selling() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicket() {
        return ticket.getId();
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getCashier() {
        return cashier.getId();
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public int getCinemagoer() {
        return cinemagoer.getId();
    }

    public void setCinemagoer(Cinemagoer cinemagoer) {
        this.cinemagoer = cinemagoer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
