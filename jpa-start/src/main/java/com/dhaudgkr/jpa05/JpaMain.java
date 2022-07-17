package com.dhaudgkr.jpa05;

import com.dhaudgkr.jpa05.domain.Member;
import com.dhaudgkr.jpa05.domain.Team;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa05");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Member member1 = new Member();
            member1.setUsername("member1");
            entityManager.persist(member1);

            entityManager.flush();
            entityManager.clear();

//            Member referenceMember = entityManager.getReference(Member.class, member1.getId());
//            System.out.println("referenceMember class : " + referenceMember.getClass());
//
//            Member findMember = entityManager.find(Member.class, member1.getId());
//            System.out.println("findMember class : " + findMember.getClass());
//
//            System.out.println("referenceMember == findMember : " + (findMember == referenceMember));

//            printUserAndTeam(entityManager, member);
//            printUser(entityManager, member);

//            Member referenceMember = entityManager.getReference(Member.class, member1.getId());
//            System.out.println("referenceMember class : " + referenceMember.getClass());
//
//            entityManager.detach(referenceMember);
//
//            System.out.println("referenceMember username : " + referenceMember.getUsername());

//            Member referenceMember = entityManager.getReference(Member.class, member1.getId());
//            System.out.println("isLoaded : " + entityManagerFactory.getPersistenceUnitUtil().isLoaded(referenceMember));
//
//            referenceMember.getUsername();
//            System.out.println("isLoaded : " + entityManagerFactory.getPersistenceUnitUtil().isLoaded(referenceMember));

            Member referenceMember = entityManager.getReference(Member.class, member1.getId());
            System.out.println("referenceMember class : " + referenceMember.getClass());

            Hibernate.initialize(referenceMember);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

    public static void printUserAndTeam(EntityManager entityManager, Member member) {
        Member findMember = entityManager.getReference(Member.class, member.getId());
        Team team = findMember.getTeam();
        System.out.println("member class : " + findMember.getClass());
        System.out.println("회원 정보 : " + findMember.getUsername());
        System.out.println("팀정보 : " + team.getName());
        System.out.println("member class : " + findMember.getClass());
    }

    public static void printUser(EntityManager entityManager, Member member) {
        Member findMember = entityManager.getReference(Member.class, member.getId());
        System.out.println("member class : " + findMember.getClass());
        System.out.println("회원 정보 : " + findMember.getUsername());
        System.out.println("member class : " + findMember.getClass());
    }
}
