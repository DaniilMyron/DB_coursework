package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Cashier;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CashierDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Cashier cashier){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(cashier);
        entityTransaction.commit();
    }

    public Cashier getBySurname(String surname){
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Cashier i WHERE i.surname = :surname1";

        TypedQuery<Cashier> typedQuery = entityManager.createQuery(query, Cashier.class);
        typedQuery.setParameter("surname1", surname);
        Cashier cashier = typedQuery.getSingleResult();

        return cashier;
    }

    public List<Cashier> getCashiers(){
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Cashier i";

        TypedQuery<Cashier> typedQuery = entityManager.createQuery(query, Cashier.class);

        return typedQuery.getResultList();
    }

    public void deleteByNameANDSurname(String name, String surname) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String query = "SELECT i FROM Cashier i WHERE i.name = :name1 AND i.surname = :surname1";
        TypedQuery<Cashier> typedQuery = entityManager.createQuery(query, Cashier.class);
        typedQuery.setParameter("name1", name);
        typedQuery.setParameter("surname1", surname);
        Cashier newCashier = typedQuery.getSingleResult();
        int id = newCashier.getId();
        Cashier cashier = entityManager.find(Cashier.class, id);

        entityManager.remove(cashier);
        entityTransaction.commit();
    }
}
