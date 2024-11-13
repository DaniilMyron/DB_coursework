package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Cashier;
import com.miron.kursach.models.Cinemagoer;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CinemagoerDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Cinemagoer cinemagoer){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(cinemagoer);
        entityTransaction.commit();
    }

    public List<Cinemagoer> getCinemagoers(){
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Cinemagoer i";

        TypedQuery<Cinemagoer> typedQuery = entityManager.createQuery(query, Cinemagoer.class);

        return typedQuery.getResultList();
    }

    public void deleteByNameANDSurname(String name, String surname) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String query = "SELECT i FROM Cinemagoer i WHERE i.name = :name1 AND i.surname = :surname1";
        TypedQuery<Cinemagoer> typedQuery = entityManager.createQuery(query, Cinemagoer.class);
        typedQuery.setParameter("name1", name);
        typedQuery.setParameter("surname1", surname);
        Cinemagoer newCinemagoer = typedQuery.getSingleResult();
        int id = newCinemagoer.getId();
        Cinemagoer cinemagoer = entityManager.find(Cinemagoer.class, id);

        entityManager.remove(cinemagoer);
        entityTransaction.commit();
    }
}
