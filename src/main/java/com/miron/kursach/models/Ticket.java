package com.miron.kursach.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private int moviegoerCount;
    private int ticketValue;
    private String movieTime;

    public Ticket() {
    }

    public Ticket(String movieName, int ticketValue, String movieTime) {
        increaseMoviegoerCount();
        this.movieName = movieName;
        this.ticketValue = ticketValue;
        this.movieTime = movieTime;
    }

    public int getMoviegoerCount() {
        return moviegoerCount;
    }

    public void increaseMoviegoerCount() {
        this.moviegoerCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMoviegoerCount(int moviegoerCount) {
        this.moviegoerCount = moviegoerCount;
    }

    public int getTicketValue() {
        return ticketValue;
    }

    public void setTicketValue(int ticketValue) {
        this.ticketValue = ticketValue;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }
}
