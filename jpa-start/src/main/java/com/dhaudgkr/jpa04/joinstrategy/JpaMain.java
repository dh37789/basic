package com.dhaudgkr.jpa04.joinstrategy;

import com.dhaudgkr.jpa04.singlestrategy.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa04_1");

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

            Movie findMovie = entityManager.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
