package com.dhaudgkr.jpa07.jpql02;

import com.dhaudgkr.jpa07.jpql02.domain.Member;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa07_2");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            entityManager.persist(member);

            /* JQPL 문법 */
            entityManager.createQuery("SELECT m FROM Member m", Member.class);
            
            /* TypedQuery, Query */
            TypedQuery<Member> query1 = entityManager.createQuery("SELECT m FROM Member m", Member.class);
            TypedQuery<String> query2 = entityManager.createQuery("SELECT m.username FROM Member m", String.class);
            Query query3 = entityManager.createQuery("SELECT m.username, m.age FROM Member m");

            /* 결과 조회 API */
            Member resultMember = query1.getSingleResult();
            System.out.println("resultMember = " + resultMember);

            /* 파라미터 바인딩 */
            TypedQuery<Member> query = entityManager.createQuery("SELECT m FROM Member m WHERE m.username = :username", Member.class);
            query.setParameter("username", "member1");
            Member member1 = query.getSingleResult();
            System.out.println("member1 : " + member1.getUsername());

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}
