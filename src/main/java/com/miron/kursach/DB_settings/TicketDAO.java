package com.miron.kursach.DB_settings;

import com.miron.kursach.models.Ticket;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TicketDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Ticket ticket){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(ticket);
        entityTransaction.commit();
    }

    public List<Ticket> getTickets(){
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Ticket i";

        TypedQuery<Ticket> typedQuery = entityManager.createQuery(query, Ticket.class);

        return typedQuery.getResultList();
    }

    public void deleteByNameANDDate(String movieName, String movieTime) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        String query = "SELECT i FROM Ticket i WHERE i.movieName = :movieName1 AND i.movieTime = :movieTime1";
        TypedQuery<Ticket> typedQuery = entityManager.createQuery(query, Ticket.class);
        typedQuery.setParameter("movieName1", movieName);
        typedQuery.setParameter("movieTime1", movieTime);
        Ticket newTicket = typedQuery.getSingleResult();
        int id = newTicket.getId();
        Ticket ticket = entityManager.find(Ticket.class, id);

        entityManager.remove(ticket);
        entityTransaction.commit();
    }

    public void edit(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Ticket newTicket = entityManager.find(Ticket.class, id);
        newTicket.setMoviegoerCount(newTicket.getMoviegoerCount() + 1);

        entityManager.persist(newTicket);
        entityTransaction.commit();
    }

    public Ticket getTicket(int id) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM Ticket i WHERE i.id = :id1";

        TypedQuery<Ticket> typedQuery = entityManager.createQuery(query, Ticket.class);
        typedQuery.setParameter("id1", id);
        Ticket ticket = typedQuery.getSingleResult();

        return ticket;
    }
}
