package com.dhaudgkr.jpa05.lazyloading;

import com.dhaudgkr.jpa05.lazyloading.domain.Member;
import com.dhaudgkr.jpa05.lazyloading.domain.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa05_1");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Team team1 = new Team();
            team1.setName("team1");
            entityManager.persist(team1);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team1);
            entityManager.persist(member1);

            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.find(Member.class, member1.getId());
            System.out.println("findMember.getTeam : " + findMember.getTeam().getClass());

            System.out.println("before call Team");
            System.out.println("team : " + findMember.getTeam().getName());
            System.out.println("after call Team");

        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

}
