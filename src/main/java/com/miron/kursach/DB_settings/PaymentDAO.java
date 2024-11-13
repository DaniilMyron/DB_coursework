package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Payment;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
public class PaymentDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Payment payment){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(payment);
        entityTransaction.commit();
    }
}
