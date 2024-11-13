package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Selling;
import com.miron.kursach.models.Ticket;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class SellingDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Selling selling) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(selling);
        entityTransaction.commit();
    }

    public List<Selling> getSellings() {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Selling i";

        TypedQuery<Selling> typedQuery = entityManager.createQuery(query, Selling.class);

        return typedQuery.getResultList();
    }
}
