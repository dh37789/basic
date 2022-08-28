package com.dhaudgkr.jpa07.jpql03;

import com.dhaudgkr.jpa07.jpql03.domain.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa07_3");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("관리자1");
            member.setAge(10);
            member.setType(MemberType.valueOf("USER"));
            member.setTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            routeExpression(entityManager);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

    public static void routeExpression(EntityManager entityManager) {
        String query1 = "SELECT m.username FROM Member m";
        List<String> result1 = entityManager.createQuery(query1, String.class)
                        .getResultList();

        String query2 = "SELECT m.team FROM Member m";
        List<Team> result2 = entityManager.createQuery(query2, Team.class)
                .getResultList();

        String query3 = "SELECT t.members FROM Team t";
        Collection result3 = entityManager.createQuery(query3, Collection.class)
                .getResultList();
    }
}
