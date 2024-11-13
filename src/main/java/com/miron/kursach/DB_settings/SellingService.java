package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Selling;
import com.miron.kursach.models.Ticket;

import java.util.List;

public class SellingService {
    private static final SellingDAO _sellingDAO = new SellingDAO();

    public static void add(Selling selling){
        _sellingDAO.add(selling);
    }
    public static List<Selling> getSellings(){return _sellingDAO.getSellings();}
}
