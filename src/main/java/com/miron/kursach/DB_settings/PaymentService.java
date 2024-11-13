package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Payment;

import java.util.List;

public class PaymentService {
    private static final PaymentDAO _paymentDAO = new PaymentDAO();

    public static void add(Payment payment){
        _paymentDAO.add(payment);
    }
}
