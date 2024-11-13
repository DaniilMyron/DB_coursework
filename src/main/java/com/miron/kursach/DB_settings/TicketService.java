package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Ticket;

import java.util.List;

public class TicketService {
    private static final TicketDAO _ticketDAO = new TicketDAO();

    public static void add(Ticket ticket){
        _ticketDAO.add(ticket);
    }
    public static List<Ticket> getTickets(){return _ticketDAO.getTickets();}
    public static Ticket getTicket(int id){return _ticketDAO.getTicket(id);}
    public static void deleteByNameANDDate(String movieName, String movieTime){
        _ticketDAO.deleteByNameANDDate(movieName, movieTime);
    }
    public static void edit(int id){
        _ticketDAO.edit(id);
    }
}
