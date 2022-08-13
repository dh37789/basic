package com.dhaudgkr.jpa07.jpql02;

import com.dhaudgkr.jpa07.jpql02.domain.Address;
import com.dhaudgkr.jpa07.jpql02.domain.Member;
import com.dhaudgkr.jpa07.jpql02.domain.MemberDto;
import com.dhaudgkr.jpa07.jpql02.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa07_2");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            for (int i = 0; i < 100; i++) {
                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i+5);
                entityManager.persist(member);
            }

            entityManager.flush();
            entityManager.clear();

//            jpqlBasic(entityManager);
//            projections(entityManager);
//            projections2(entityManager);
//            paging(entityManager);



            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

    private static void jpqlBasic(EntityManager entityManager) {
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
    }

    private static void projections(EntityManager entityManager) {
        /* 프로젝션 */
        List<Member> members = entityManager.createQuery("SELECT m from Member m", Member.class)
                .getResultList();

        Member findMember = members.get(0);
        findMember.setAge(30);

        /* 프로젝션 */
        List<Team> teams = entityManager.createQuery("SELECT m.team from Member m", Team.class)
                .getResultList();

        /* 프로젝션 */
        entityManager.createQuery("SELECT o.address from Order o", Address.class)
                .getResultList();

        /* 스칼라 프로젝션 */
        entityManager.createQuery("SELECT m.username, m.age from Member m")
                .getResultList();
    }

    private static void projections2(EntityManager entityManager) {
        /* Object */
        List objectList = entityManager.createQuery("SELECT m.username, m.age from Member m")
                .getResultList();

        Object o = objectList.get(0);
        Object[] objects = (Object[]) o;
        System.out.println("objects.username : " + objects[0]);
        System.out.println("objects.age : " + objects[1]);

        /* Object[] */
        List<Object[]> results = entityManager.createQuery("SELECT m.username, m.age from Member m")
                .getResultList();

        Object[] objects2 = results.get(0);
        System.out.println("objects.username : " + objects2[0]);
        System.out.println("objects.age : " + objects2[1]);


        /* new 이용 방식 */
        List<MemberDto> result = entityManager.createQuery("SELECT new com.dhaudgkr.jpa07.jpql02.domain.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                .getResultList();
        MemberDto memberDto = result.get(0);
        System.out.println("MemberDto.username : " + memberDto.getUsername());
        System.out.println("MemberDto.age : " + memberDto.getAge());
    }

    private static void paging(EntityManager entityManager) {
        List<Member> memberList = entityManager.createQuery("SELECT m FROM Member m ORDER BY m.age DESC", Member.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();

        System.out.println("memberList.size : " + memberList.size());
        for (Member findMember : memberList) {
            System.out.println("findMember.username : " + findMember);
        }
    }
}
