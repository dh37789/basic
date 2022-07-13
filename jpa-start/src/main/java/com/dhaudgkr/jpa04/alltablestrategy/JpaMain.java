package com.dhaudgkr.jpa04.alltablestrategy;

import com.dhaudgkr.jpa04.alltablestrategy.domain.Item;
import com.dhaudgkr.jpa04.alltablestrategy.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa04_3");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Movie movie = new Movie();
            movie.setDirector("조셉 코신스키");
            movie.setName("탑건2 매버릭");
            movie.setActor("톰 크루즈");
            movie.setPrice(9900);

            entityManager.persist(movie);

            entityManager.flush();
            entityManager.clear();

            Item item = entityManager.find(Item.class, movie.getId());
            System.out.println("findMovie = " + item);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
