package com.dhaudgkr.jpa03.onetomany;

import com.dhaudgkr.jpa03.onetomany.domain.Member;
import com.dhaudgkr.jpa03.onetomany.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello4");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            entityManager.persist(member);

            Team team = new Team();
            team.setName("TeamA");
            team.getMembers().add(member);
            entityManager.persist(team);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
