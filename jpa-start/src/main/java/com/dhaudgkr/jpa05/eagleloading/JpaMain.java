package com.dhaudgkr.jpa05.eagleloading;

import com.dhaudgkr.jpa05.eagleloading.domain.Member;
import com.dhaudgkr.jpa05.eagleloading.domain.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa05_2");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Team team1 = new Team();
            team1.setName("team1");
            entityManager.persist(team1);

            Team team2 = new Team();
            team2.setName("team2");
            entityManager.persist(team2);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team1);
            entityManager.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(team2);
            entityManager.persist(member2);

            entityManager.flush();
            entityManager.clear();

//            Member findMember = entityManager.find(Member.class, member1.getId());
//            System.out.println("findMember.getTeam : " + findMember.getTeam().getClass());

            List<Member> members = entityManager.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
