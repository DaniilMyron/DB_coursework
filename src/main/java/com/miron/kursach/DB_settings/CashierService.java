package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Cashier;

import java.util.List;

public class CashierService {
    private static final CashierDAO _cashierDAO = new CashierDAO();

    public static void add(Cashier cashier){
        _cashierDAO.add(cashier);
    }
    public static List<Cashier> getCashiers(){return _cashierDAO.getCashiers();}
    public static Cashier getBySurname(String surname){return _cashierDAO.getBySurname(surname);}
    public static void deleteByNameANDSurname(String name, String surname){
        _cashierDAO.deleteByNameANDSurname(name, surname);
    }
}
