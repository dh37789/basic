package com.dhaudgkr.jpa03.manytoone;

import com.dhaudgkr.jpa02.domain.Member;
import com.dhaudgkr.jpa02.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello3");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            entityManager.persist(member);

            Team team = new Team();
            team.setName("TeamA");
            team.addMember(member);
            entityManager.persist(team);

            entityManager.flush();
            entityManager.clear();

            Team findTeam = entityManager.find(Team.class, team.getId());
            System.out.println(findTeam);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
