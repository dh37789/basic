package com.dhaudgkr.jpa01.hellojpa;

import com.dhaudgkr.jpa01.hellojpa.entity.Member;
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
//        saveLazy(entityManager, entityTransaction);
//        flush(entityManager, entityTransaction);
//        detach(entityManager, entityTransaction);
        clear(entityManager, entityTransaction);
        entityManagerFactory.close();
    }

    private static void clear(EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();
        try {
            Member findMemberA = entityManager.find(Member.class, 102L);
            log.debug("clear - BEFORE");
            entityManager.clear();
            log.debug("clear - AFTER");
            Member findMemberB = entityManager.find(Member.class, 102L);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    private static void detach(EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();
        try {
            Member findMemberA = entityManager.find(Member.class, 102L);
            findMemberA.setName("Modify JAVA");

            log.debug("detach - BEFORE");
//            entityManager.detach(findMemberA);
            entityManager.detach(findMemberA);
            log.debug("detach - AFTER");

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
    private static void flush(EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();
        try {
            log.debug("member persist - BEFORE");
            Member member = new Member(105L, "member200");
            entityManager.persist(member);
            log.debug("member persist - AFTER");

            log.debug("member flush - BEFORE");
            /* 쿼리 생성 */
            entityManager.flush();
            log.debug("member flush - AFTER");

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
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
