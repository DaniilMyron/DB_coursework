package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Cinemagoer;
import com.miron.kursach.models.Ticket;

import java.util.List;

public class CinemagoerService {
    private static final CinemagoerDAO _cinemagoerDAO = new CinemagoerDAO();

    public static void add(Cinemagoer cinemagoer){
        _cinemagoerDAO.add(cinemagoer);
    }
    public static List<Cinemagoer> getCinemagoers(){return _cinemagoerDAO.getCinemagoers();}
    public static void deleteByNameANDSurname(String name, String surname){
        _cinemagoerDAO.deleteByNameANDSurname(name, surname);
    }
}
