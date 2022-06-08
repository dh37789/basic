package com.dhaudgkr.jpastart.hellojpa;

import com.dhaudgkr.jpastart.hellojpa.entity.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class JpaPersistent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

//        persist(entityManager, entityTransaction);
//        readLazy(entityManager, entityTransaction);
        saveLazy(entityManager, entityTransaction);

        entityManagerFactory.close();
    }

    private static void saveLazy(EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();
        try {
            log.debug("memberA persist - BEFORE");
            Member memberA = new Member(103L, "memberA");
            entityManager.persist(memberA);
            log.debug("memberA persist - AFTER");
            log.debug("memberB persist - BEFORE");
            Member memberB = new Member(104L, "memberB");
            entityManager.persist(memberB);
            log.debug("memberB persist - AFTER");
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void readLazy(EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();
        try {
            log.debug("memberA 조회 - BEFORE");
            Member findMemberA = entityManager.find(Member.class, 102L);
            log.debug("memberA 조회 - AFTER");
            log.debug("memberB 조회 - BEFORE");
            Member findMemberB = entityManager.find(Member.class, 102L);
            log.debug("memberB 조회 - AFTER");
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void persist(EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();
        try {
            Member member = new Member(102L, "Hello JPA");

            System.out.println("=== PERSISTENT BEFORE ===");
            entityManager.persist(member);
            System.out.println("=== PERSISTENT AFTER ===");
            Member findMember = entityManager.find(Member.class, 102L);
            log.debug("findMember.id : " + findMember.getId());
            log.debug("findMember.name : " + findMember.getName());
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
}
